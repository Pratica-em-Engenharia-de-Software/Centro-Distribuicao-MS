package com.pes.centro_distribuicao_ms.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IncludeAddressRequest {
    
    @NotBlank(message = "Country is required")
    private String country;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Neighborhood is required")
    private String neighborhood;
    @NotBlank(message = "Street is required")
    private String street;
    @NotNull(message = "Number is required")
    private Integer number;
}
