package com.example.customermanager.adapter.in.controller;

import com.example.customermanager.adapter.in.controller.dto.JwtRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IJwtAuthenticationController {

    @Operation(summary = "Perform an authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perform authentication",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to authenticate",
                    content = @Content)
    })
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception;
}
