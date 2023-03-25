package com.example.customermanager.application.in;

import com.example.customermanager.application.out.*;
import com.example.customermanager.commons.enums.CustomerStatus;
import com.example.customermanager.commons.enums.MetricType;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService implements ICustomerService {

    private final IPrometheusAdapter metric;
    private final ICustomerPersistenceAdapter customerPersistenceAdapter;
    private final IAddressPersistenceAdapter addressPersistenceAdapter;
    private final IAccountPersistenceAdapter accountPersistenceAdapter;
    private final IStorageServiceAdapter storageService;
    private final IFraudAnalysisIntegration fraudAnalysisIntegration;

    @Override
    public Customer create(Customer customer) {
        log.info("M=CustomerService.create customer={}", customer);
        metric.count(MetricType.COUNTER_REQUEST_CREATE_CUSTOMER);

        createAddress(customer);
        customer = customerPersistenceAdapter.create(customer);
        createAccount(customer);

        return customer;
    }

    @Override
    public Customer get(Long id) {
        try {
            return customerPersistenceAdapter.get(id);
        } catch (RegisterNotFoundException e) {
            log.error("CustomerService.get Register not found id={}", id);
        }

        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customerPersistenceAdapter.getAll();
    }

    @Override
    public Document processDocument(MultipartFile file, Long idtCustomer) {
        Document document = storageService.sendFile(file);

        document.setIdtCustomer(idtCustomer);
        fraudAnalysisIntegration.sendAnalysis(document);
        return document;
    }

    @Override
    public CustomerAnalysis updateAnalysis(CustomerAnalysis customerAnalysis) {
        Boolean success = Boolean.TRUE;

        try {
            Customer customer = customerPersistenceAdapter.get(customerAnalysis.getIdtCustomer());

            CustomerStatus status = customerAnalysis.getStatus() ? CustomerStatus.ACTIVE : CustomerStatus.INACTIVE;
            customer.setStatus(status);

            customerPersistenceAdapter.update(customer);
        } catch (RegisterNotFoundException e) {
            log.error("M=CustomerService.updateAnalysis Error when trying to perform status update error={}", e.getMessage());
            success = Boolean.FALSE;

        } finally {
            metric.count(MetricType.COUNTER_ANALYSIS_STATUS, "status", String.valueOf(success));
        }

        return customerAnalysis;
    }

    private void createAddress(Customer customer) {
        Address address = addressPersistenceAdapter.create(customer.getAddress());
        customer.setAddress(address);
    }

    private void createAccount(Customer customer) {
        List<Account> listAccount = new ArrayList<>();
        for (Account account : customer.getListAccount()) {
            account.setIdtCustomer(customer.getId());
            listAccount.add(accountPersistenceAdapter.create(account));
        }

        customer.setAccount(listAccount);
    }
}
