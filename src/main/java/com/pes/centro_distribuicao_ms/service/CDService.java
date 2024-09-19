package com.pes.centro_distribuicao_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pes.centro_distribuicao_ms.controller.request.IncludeCDRequest;
import com.pes.centro_distribuicao_ms.controller.response.CDCodeResponse;
import com.pes.centro_distribuicao_ms.controller.response.CDResponse;
import com.pes.centro_distribuicao_ms.domain.CentroDistribuicao;
import com.pes.centro_distribuicao_ms.mapper.CDMapper;
import com.pes.centro_distribuicao_ms.repository.CDRepository;

import jakarta.transaction.Transactional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;;

@Service
public class CDService {
    
    @Autowired
    private CDRepository cdRepository;

    // gets

    public CDResponse getCDByID(long codCD){
        return cdRepository.findByCode(codCD)
        .map(CDMapper::toResponse)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Centro de Distribuição not found"));
    }

    public CDResponse getCDByName(String nameCD){
        return cdRepository.findByName(nameCD)
        .map(CDMapper::toResponse)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Centro de Distribuição not found"));
    }

    public List<CDResponse> getAllCDs(){
        return cdRepository.findAll().stream()
        .map(CDMapper::toResponse)
        .collect(Collectors.toList());
    }

    // posts

    @Transactional
    public CDCodeResponse include(IncludeCDRequest request){
        CentroDistribuicao cd = CDMapper.toEntity(request);

        cdRepository.save(cd);

        return CDMapper.toCodeResponse(cd.getCode());
    }
}
