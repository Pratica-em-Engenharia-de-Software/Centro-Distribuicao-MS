package com.pes.centro_distribuicao_ms.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class IncludeCDRequest {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "phone is required")
    private String phone;
    @NotBlank(message = "email is required")
    private String email;
    //@NotBlank(message = "code is required")
    //private String code;

    @Valid
    @NotBlank(message = "address is required")
    private IncludeAddressRequest address;
}
