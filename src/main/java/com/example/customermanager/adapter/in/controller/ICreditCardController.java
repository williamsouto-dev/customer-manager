package com.example.customermanager.adapter.in.controller;

import com.example.customermanager.adapter.in.controller.dto.CreditCardRequest;
import com.example.customermanager.adapter.in.controller.dto.CreditCardResponse;
import com.example.customermanager.commons.exception.CreditCardException;
import com.example.customermanager.commons.exception.RegisterNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

public interface ICreditCardController {

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Create a new credit card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit card created successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Error trying to create card",
                    content = @Content)
    })
    CreditCardResponse create(@Parameter(description = "Payload with card data", required = true) CreditCardRequest request) throws CreditCardException;

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get all credit cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all credit cards successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Error fetching credit cards",
                    content = @Content)
    })
    List<CreditCardResponse> search() throws CreditCardException;

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get a credit card by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get a credit card by id successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Error fetching credit card",
                    content = @Content)
    })
    CreditCardResponse searchById(@Parameter(description = "Id", required = true) Long idtCreditCard) throws RegisterNotFoundException;

    String validCript() throws CreditCardException;
}
