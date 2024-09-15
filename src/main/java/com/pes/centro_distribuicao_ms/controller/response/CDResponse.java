package com.pes.centro_distribuicao_ms.controller.response;

import lombok.Data;

@Data
public class CDResponse {

    private String name;
    private String phone;
    private String email;
    private String code;

    private AddressResponse address;
}
