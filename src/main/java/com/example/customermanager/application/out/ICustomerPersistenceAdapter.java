package com.example.customermanager.application.out;

import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.domain.Customer;
import java.util.List;

public interface ICustomerPersistenceAdapter {

    Customer create(Customer customer);

    void update(Customer customer);

    Customer get(Long id) throws RegisterNotFoundException;

    List<Customer> getAll();
}
