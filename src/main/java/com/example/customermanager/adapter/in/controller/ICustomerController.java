package com.example.customermanager.adapter.in.controller;

import com.example.customermanager.adapter.in.controller.dto.CustomerAnalysisRequest;
import com.example.customermanager.adapter.in.controller.dto.CustomerRequest;
import com.example.customermanager.adapter.in.controller.dto.CustomerResponse;
import com.example.customermanager.adapter.in.controller.dto.DocumentResponse;
import com.example.customermanager.domain.CustomerAnalysis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICustomerController {

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Register new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer registered successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
                    content = @Content)
    })
    CustomerResponse create(@Parameter(description = "Payload with customer parameters", required = true) CustomerRequest request);

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Upload document file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully sent",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid file",
                    content = @Content)
    })
    DocumentResponse receiveDocuments(@Parameter(description = "Customer documents", required = true) MultipartFile document,
                                      @Parameter(description = "Id customer", required = true) Long id);

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Search all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successful",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Error fetching users",
                    content = @Content)
    })
    List<CustomerResponse> getAll();

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Search customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successful",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Error fetching users",
                    content = @Content)
    })
    CustomerResponse get(@Parameter(description = "Id customer", required = true) Long id);

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Update analysis customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update successful",
                    content = { @Content(mediaType = "application/x-www-form-urlencoded")}),
            @ApiResponse(responseCode = "400", description = "Error to update status",
                    content = @Content)
    })
    void updateAnalysis(@Parameter(description = "Data Analysis", required = true) CustomerAnalysisRequest request);
}
