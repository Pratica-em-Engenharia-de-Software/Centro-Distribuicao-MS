package com.pes.centro_distribuicao_ms.controller;

import lombok.Data;

@Data
public class AddressResponse {

    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int number;
}
