package com.pes.centro_distribuicao_ms.mapper;

import com.pes.centro_distribuicao_ms.controller.AddressResponse;
import com.pes.centro_distribuicao_ms.controller.CDResponse;
import com.pes.centro_distribuicao_ms.domain.CentroDistribuicao;

public class CDMapper {
    
    public static CDResponse toResponse(CentroDistribuicao cd){
        CDResponse response = new CDResponse();
        AddressResponse addressResponse = new AddressResponse();

        response.setCode(cd.getCode());
        response.setEmail(cd.getEmail());
        response.setName(cd.getName());
        response.setPhone(cd.getPhone());

        addressResponse.setCountry(cd.getAddress().getCountry());
        addressResponse.setState(cd.getAddress().getState());
        addressResponse.setCity(cd.getAddress().getCity());
        addressResponse.setNeighborhood(cd.getAddress().getNeighborhood());
        addressResponse.setStreet(cd.getAddress().getStreet());
        addressResponse.setNumber(cd.getAddress().getNumber());

        response.setAddress(addressResponse);

        return response;
    }
}
