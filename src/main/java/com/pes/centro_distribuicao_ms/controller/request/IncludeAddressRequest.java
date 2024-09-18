package com.pes.centro_distribuicao_ms.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IncludeAddressRequest {
    
    @NotBlank(message = "country is required")
    private String country;
    @NotBlank(message = "state is required")
    private String state;
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "neighborhood is required")
    private String neighborhood;
    @NotBlank(message = "street is required")
    private String street;
    @NotNull(message = "number is required")
    private Integer number;
}
