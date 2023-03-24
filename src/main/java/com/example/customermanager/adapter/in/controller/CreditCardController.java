package com.example.customermanager.adapter.in.controller;

import com.example.customermanager.adapter.in.controller.dto.CreditCardRequest;
import com.example.customermanager.adapter.in.controller.dto.CreditCardResponse;
import com.example.customermanager.application.in.ICreditCardService;
import com.example.customermanager.commons.exception.CreditCardException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import com.example.customermanager.commons.utils.Reflection;
import com.example.customermanager.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/credit-card")
public class CreditCardController implements ICreditCardController {

    private final ICreditCardService service;

    @PostMapping
    @Override
    public CreditCardResponse create(@RequestBody CreditCardRequest request) throws CreditCardException {

        CreditCard creditCard = service.create(Reflection.instance().convert(request, CreditCard.class).check());
        return Reflection.instance().convert(creditCard, CreditCardResponse.class);
    }

    @Override
    @GetMapping
    public List<CreditCardResponse> search() throws CreditCardException {
        return service.search().stream().map(creditCard -> {
            CreditCardResponse response = Reflection.instance().convert(creditCard, CreditCardResponse.class);
            response.applyMaskfieldNumber();
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public CreditCardResponse searchById(@PathVariable Long id) throws RegisterNotFoundException {
        return Reflection.instance().convert(service.searchById(id), CreditCardResponse.class);
    }

    @Override
    @GetMapping("/valid")
    public String validCript() throws CreditCardException {
        return service.valid();
    }
}
