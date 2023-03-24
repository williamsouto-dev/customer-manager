package com.example.customermanager.application.in;

import com.example.customermanager.application.out.IAccountPersistenceAdapter;
import com.example.customermanager.application.out.ICreditCardPersistenceAdapter;
import com.example.customermanager.application.out.ICustomerPersistenceAdapter;
import com.example.customermanager.commons.enums.CreditCardStatus;
import com.example.customermanager.commons.enums.ErrorException;
import com.example.customermanager.commons.exception.CreditCardException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.commons.security.aes.AESSecurity;
import com.example.customermanager.commons.utils.CreditCardUtils;
import com.example.customermanager.domain.Account;
import com.example.customermanager.domain.CreditCard;
import com.example.customermanager.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditCardService implements ICreditCardService {

    private final ICreditCardPersistenceAdapter creditCardPersistenceAdapter;
    private final ICustomerPersistenceAdapter customerPersistenceAdapter;
    private final IAccountPersistenceAdapter accountPersistenceAdapter;
    private final AESSecurity security;

    @Override
    public CreditCard create(CreditCard creditCard) throws CreditCardException {
        try {
            Customer customer = customerPersistenceAdapter.get(creditCard.getIdtCustomer());
            Account account = accountPersistenceAdapter.getById(creditCard.getIdtAccount());

            creditCard.setAccount(account);
            creditCard.setCustomer(customer);
            creditCard.setStatus(CreditCardStatus.INACTIVE);

            String numberCard = CreditCardUtils.instance().generate(CreditCardUtils.NUMBER_CARD);
            String numberCvv = CreditCardUtils.instance().generate(CreditCardUtils.NUMBER_CVV);

            creditCard.setNumber(this.encrypt(numberCard));
            creditCard.setCvv(this.encrypt(numberCvv));

            creditCard = creditCardPersistenceAdapter.create(creditCard);
            return creditCard;
        } catch (RegisterNotFoundException e) {
            log.error("M=CreditCardService.create Error create credit card error={}", e.getMessage());
            throw new CreditCardException(ErrorException.CREDIT_CARD_ERROR.getCode(), ErrorException.CREDIT_CARD_ERROR.getMessage());
        }
    }

    @Override
    public List<CreditCard> search() throws CreditCardException {
        List<CreditCard> listCreditCard = creditCardPersistenceAdapter.getAll();

        for (CreditCard creditCard : listCreditCard) {
            creditCard.setNumber(this.decrypt(creditCard.getNumber()));
        }

        return listCreditCard;
    }

    @Override
    public CreditCard searchById(Long id) throws RegisterNotFoundException {
        return creditCardPersistenceAdapter.getByid(id);
    }

    @Override
    public String valid() throws CreditCardException {
        String plainText = Strings.EMPTY;
        String plainText2 = Strings.EMPTY;

        try {
            String input = "baeldung";

            String cipherText = security.encrypt(input);
            plainText = security.decrypt(cipherText);

            String result = security.encrypt("wil");
            plainText2 = security.decrypt(result);
            security.encrypt("wil");


        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                 NoSuchAlgorithmException | BadPaddingException | InvalidKeySpecException | InvalidKeyException e) {
            log.error("M=CreditCardService.encrypt error to encrypt input error={}", e.getMessage());
            throw new CreditCardException(ErrorException.ERROR_APPLY_SECURITY.getCode(), ErrorException.ERROR_APPLY_SECURITY.getMessage());
        }
        return plainText;
    }

    private String encrypt(String input) throws CreditCardException {
        log.info("M=CreditCardService.encrypt input={}", input);

        try {
            return (new AESSecurity()).encrypt(input);
        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                 NoSuchAlgorithmException | BadPaddingException | InvalidKeySpecException | InvalidKeyException e) {
            log.error("M=CreditCardService.encrypt error to encrypt input error={}", e.getMessage());
            throw new CreditCardException(ErrorException.ERROR_APPLY_SECURITY.getCode(), ErrorException.ERROR_APPLY_SECURITY.getMessage());
        }
    }

    private String decrypt(String cipher) throws CreditCardException {
        log.info("M=CreditCardService.decrypt cipher={}", cipher);

        try {
            return (new AESSecurity()).decrypt(cipher);
        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                 NoSuchAlgorithmException | BadPaddingException | InvalidKeySpecException | InvalidKeyException e) {
            log.error("M=CreditCardService.decrypt error to decrypt cipher error={}", e.getMessage());
            throw new CreditCardException(ErrorException.ERROR_APPLY_SECURITY.getCode(), ErrorException.ERROR_APPLY_SECURITY.getMessage());
        }
    }
}
