package com.example.customermanager.adapter.out.persistence;

import com.example.customermanager.adapter.out.persistence.entity.AddressEntity;
import com.example.customermanager.adapter.out.persistence.repository.AddressRepository;
import com.example.customermanager.application.out.IAddressPersistenceAdapter;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.Address;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class AddressPersistenceAdapter implements IAddressPersistenceAdapter {

    private final AddressRepository repository;

    @Override
    public Address create(Address address) {
        AddressEntity addressEntity = repository.save(Reflection.instance().convert(address, AddressEntity.class));
        address.setId(addressEntity.getId());
        address.setDatCreate(addressEntity.getDatCreate());
        address.setDatUpdate(addressEntity.getDatUpdate());

        return address;
    }
}
