package com.example.customermanager.adapter.in.controller;

import com.example.customermanager.adapter.in.controller.dto.CustomerAnalysisRequest;
import com.example.customermanager.adapter.in.controller.dto.CustomerRequest;
import com.example.customermanager.adapter.in.controller.dto.CustomerResponse;
import com.example.customermanager.adapter.in.controller.dto.DocumentResponse;
import com.example.customermanager.application.in.ICustomerService;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.Customer;
import com.example.customermanager.domain.CustomerAnalysis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController implements ICustomerController {

    private final ICustomerService customerService;

    @Override
    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest request) {
        log.info("M=CustomerController.create request={}", request);

        Customer customer = customerService.create(Reflection.instance().convert(request, Customer.class).check());
        return Reflection.instance().convert(customer, CustomerResponse.class);
    }

    @Override
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/upload-document/{idtCustomer}")
    public DocumentResponse receiveDocuments(@RequestPart(value = "file") MultipartFile document, @PathVariable Long idtCustomer) {
        return Reflection.instance().convert(customerService.processDocument(document, idtCustomer), DocumentResponse.class);
    }

    @Override
    @GetMapping
    public List<CustomerResponse> getAll() {
        return customerService.getAll().stream()
                .map(customer -> Reflection.instance().convert(customer, CustomerResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public CustomerResponse get(@PathVariable Long id) {
        return Reflection.instance().convert(customerService.get(id), CustomerResponse.class);
    }

    @Override
    @PostMapping("/status")
    public void updateAnalysis(CustomerAnalysisRequest request) {
        CustomerAnalysis analysis = customerService.updateAnalysis(Reflection.instance().convert(request, CustomerAnalysis.class).check());
    }
}
