package com.example.customermanager.application.in;

import com.example.customermanager.commons.exception.CreditCardException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.domain.CreditCard;
import java.util.List;

public interface ICreditCardService {

    CreditCard create(CreditCard creditCard) throws CreditCardException;

    List<CreditCard> search() throws CreditCardException;

    CreditCard searchById(Long id) throws RegisterNotFoundException;

    String valid() throws CreditCardException;
}
