package com.example.customermanager.application.out;

import com.example.customermanager.domain.Address;

public interface IAddressPersistenceAdapter {

    Address create(Address address);
}
