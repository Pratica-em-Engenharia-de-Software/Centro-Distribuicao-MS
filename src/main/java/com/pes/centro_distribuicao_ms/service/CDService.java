package com.pes.centro_distribuicao_ms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pes.centro_distribuicao_ms.controller.AddressResponse;
import com.pes.centro_distribuicao_ms.controller.CDResponse;
import com.pes.centro_distribuicao_ms.domain.Address;
import com.pes.centro_distribuicao_ms.domain.CentroDistribuicao;
import com.pes.centro_distribuicao_ms.repository.AddressRepository;
import com.pes.centro_distribuicao_ms.repository.CDRepository;

public class CDService {
    
    @Autowired
    private CDRepository cdRepository;
    @Autowired
    private AddressRepository addressRepository;

    public CDResponse getByID(Long codCD){
        CentroDistribuicao temp = cdRepository.getReferenceById(codCD);
        CDResponse response = new CDResponse();
        response.setCode(temp.getCode());
        response.setEmail(temp.getEmail());
        response.setName(temp.getName());
        response.setPhone(temp.getPhone());
        Address temp2 = temp.getAddress();

        AddressResponse temp3 = new AddressResponse();

        temp3.setCity(temp2.getCity());
        temp3.setCountry(temp2.getCountry());
        temp3.setNeighborhood(temp2.getNeighborhood());
        temp3.setNumber(temp2.getNumber());
        temp3.setState(temp2.getState());
        temp3.setStreet(temp2.getStreet());

        response.setAddress(temp3);

        return response;
    }
}
