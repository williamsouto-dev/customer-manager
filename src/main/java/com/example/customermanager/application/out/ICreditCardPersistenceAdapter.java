package com.example.customermanager.application.out;

import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.domain.CreditCard;
import java.util.List;

public interface ICreditCardPersistenceAdapter {

    CreditCard create(CreditCard card);

    List<CreditCard> getAll();

    CreditCard getByid(Long id) throws RegisterNotFoundException;
}
