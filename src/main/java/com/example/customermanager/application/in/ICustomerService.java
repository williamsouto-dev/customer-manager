package com.example.customermanager.application.in;

import com.example.customermanager.domain.Customer;
import com.example.customermanager.domain.CustomerAnalysis;
import com.example.customermanager.domain.Document;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ICustomerService {

    Customer create(Customer customer);

    Customer get(Long idtCustomer);

    List<Customer> getAll();

    Document processDocument(MultipartFile file, Long idtCustomer);

    CustomerAnalysis updateAnalysis(CustomerAnalysis customerAnalysis);
}
