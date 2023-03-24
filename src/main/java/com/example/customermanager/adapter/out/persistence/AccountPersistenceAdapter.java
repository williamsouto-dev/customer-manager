package com.example.customermanager.adapter.out.persistence;

import com.example.customermanager.adapter.out.persistence.entity.AccountEntity;
import com.example.customermanager.adapter.out.persistence.repository.AccountRepository;
import com.example.customermanager.application.out.IAccountPersistenceAdapter;
import com.example.customermanager.commons.enums.ErrorException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AccountPersistenceAdapter implements IAccountPersistenceAdapter {

    private final AccountRepository repository;

    @Override
    public Account create(Account account) {
        AccountEntity entity = repository.save(Reflection.instance().convert(account, AccountEntity.class));

        account.setId(entity.getId());
        account.setDatCreate(entity.getDatCreate());
        account.setDatUpdate(entity.getDatUpdate());

        return account;
    }

    @Override
    public Account getById(Long id) throws RegisterNotFoundException {
        Optional<AccountEntity> accountEntity = repository.findById(id);

        if (accountEntity.isEmpty()) {
            throw new RegisterNotFoundException(ErrorException.REGISTER_NOT_FOUND.getCode(), ErrorException.REGISTER_NOT_FOUND.getMessage());
        }

        return Reflection.instance().convert(accountEntity.get(), Account.class);
    }
}
