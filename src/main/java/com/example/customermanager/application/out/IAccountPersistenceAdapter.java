package com.example.customermanager.application.out;

import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.domain.Account;

public interface IAccountPersistenceAdapter {

    Account create(Account account);
    Account getById(Long id) throws RegisterNotFoundException;
}
