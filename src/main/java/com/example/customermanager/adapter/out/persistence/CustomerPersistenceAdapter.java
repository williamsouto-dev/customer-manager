package com.example.customermanager.adapter.out.persistence;

import com.example.customermanager.adapter.out.persistence.entity.AddressEntity;
import com.example.customermanager.adapter.out.persistence.entity.CustomerEntity;
import com.example.customermanager.adapter.out.persistence.repository.CustomerRepository;
import com.example.customermanager.application.out.ICustomerPersistenceAdapter;
import com.example.customermanager.commons.enums.CustomerStatus;
import com.example.customermanager.commons.enums.ErrorException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.Address;
import com.example.customermanager.domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerPersistenceAdapter implements ICustomerPersistenceAdapter {

    private final CustomerRepository repository;

    @Override
    public Customer create(Customer customer) {
        customer.setStatus(CustomerStatus.INACTIVE);

        CustomerEntity entity = Reflection.instance().convert(customer, CustomerEntity.class);
        AddressEntity address = Reflection.instance().convert(customer.getAddress(), AddressEntity.class);
        entity.setAddress(address);

        entity = repository.save(entity);

        customer.setStatus(CustomerStatus.INACTIVE);
        customer.setId(entity.getId());
        customer.setDatCreate(entity.getDatCreate());
        customer.setDatUpdate(entity.getDatUpdate());

        return customer;
    }

    @Override
    public void update(Customer customer) {
        CustomerEntity entity = Reflection.instance().convert(customer, CustomerEntity.class);
        AddressEntity address = Reflection.instance().convert(customer.getAddress(), AddressEntity.class);

        entity.setAddress(address);
        repository.save(entity);
    }

    @Override
    public Customer get(Long id) throws RegisterNotFoundException {
        Optional<CustomerEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new RegisterNotFoundException(ErrorException.REGISTER_NOT_FOUND.getCode(), ErrorException.REGISTER_NOT_FOUND.getMessage());
        }

        Customer customer = Reflection.instance().convert(entity.get(), Customer.class);
        AddressEntity address = entity.get().getAddress();

        customer.setAddress(Reflection.instance().convert(address, Address.class));
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll().stream().map(userEntity -> Reflection.instance().convert(userEntity, Customer.class)).collect(Collectors.toList());
    }
}
