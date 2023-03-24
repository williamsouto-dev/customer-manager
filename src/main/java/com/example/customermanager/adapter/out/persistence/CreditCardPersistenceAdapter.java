package com.example.customermanager.adapter.out.persistence;

import com.example.customermanager.adapter.out.persistence.entity.AccountEntity;
import com.example.customermanager.adapter.out.persistence.entity.CreditCardEntity;
import com.example.customermanager.adapter.out.persistence.entity.CustomerEntity;
import com.example.customermanager.adapter.out.persistence.repository.CreditCardRepository;
import com.example.customermanager.application.out.ICreditCardPersistenceAdapter;
import com.example.customermanager.commons.enums.ErrorException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.CreditCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditCardPersistenceAdapter implements ICreditCardPersistenceAdapter {

    private final CreditCardRepository repository;

    @Override
    public CreditCard create(CreditCard card) {
        CreditCardEntity creditCard = Reflection.instance().convert(card, CreditCardEntity.class);
        AccountEntity account = Reflection.instance().convert(card.getAccount(), AccountEntity.class);
        CustomerEntity customer = Reflection.instance().convert(card.getCustomer(), CustomerEntity.class);

        creditCard.setAccount(account);
        creditCard.setCustomer(customer);
        creditCard = repository.save(creditCard);

        card.setDatCreate(creditCard.getDatCreate());
        return card;
    }

    @Override
    public List<CreditCard> getAll() {
        return repository.findAll().stream().map(creditCardEntity -> Reflection.instance().convert(creditCardEntity, CreditCard.class)).collect(Collectors.toList());
    }

    @Override
    public CreditCard getByid(Long id) throws RegisterNotFoundException {
        Optional<CreditCardEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new RegisterNotFoundException(ErrorException.REGISTER_NOT_FOUND.getCode(), ErrorException.REGISTER_NOT_FOUND.getMessage());
        }

        return Reflection.instance().convert(entity.get(), CreditCard.class);
    }
}
