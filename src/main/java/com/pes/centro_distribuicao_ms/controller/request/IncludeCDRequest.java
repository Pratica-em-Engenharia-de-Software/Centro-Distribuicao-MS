package com.pes.centro_distribuicao_ms.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IncludeCDRequest {

    @NotNull(message = "Name is required")
    private String name;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "Email is required")
    private String email;

    @Valid
    @NotNull(message = "Address is required")
    private IncludeAddressRequest address;
}
