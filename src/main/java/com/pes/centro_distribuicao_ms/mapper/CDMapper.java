package com.pes.centro_distribuicao_ms.mapper;

import com.pes.centro_distribuicao_ms.controller.request.IncludeCDRequest;
import com.pes.centro_distribuicao_ms.controller.response.AddressResponse;
import com.pes.centro_distribuicao_ms.controller.response.CDCodeResponse;
import com.pes.centro_distribuicao_ms.controller.response.CDResponse;
import com.pes.centro_distribuicao_ms.domain.Address;
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

    public static CentroDistribuicao toEntity(IncludeCDRequest request){
        CentroDistribuicao entity = new CentroDistribuicao();
        Address address = new Address();

        //entity.setCode(request.getCode());
        entity.setEmail(request.getEmail());
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());

        address.setCountry(request.getAddress().getCountry());
        address.setState(request.getAddress().getState());
        address.setCity(request.getAddress().getCity());
        address.setNeighborhood(request.getAddress().getNeighborhood());
        address.setStreet(request.getAddress().getStreet());
        address.setNumber(request.getAddress().getNumber());

        entity.setAddress(address);

        return entity;
    }

    public static CDCodeResponse toCodeResponse(Long code){
        CDCodeResponse cdCodeResponse = new CDCodeResponse();

        cdCodeResponse.setCode(code);

        return cdCodeResponse;
    }
}
