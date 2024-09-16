package com.pes.centro_distribuicao_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pes.centro_distribuicao_ms.controller.request.IncludeCDRequest;
import com.pes.centro_distribuicao_ms.controller.response.CDResponse;
import com.pes.centro_distribuicao_ms.domain.CentroDistribuicao;
import com.pes.centro_distribuicao_ms.mapper.CDMapper;
import com.pes.centro_distribuicao_ms.repository.CDRepository;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;
import java.util.stream.Collectors;;

@Service
public class CDService {
    
    @Autowired
    private CDRepository cdRepository;

    // gets

    public CDResponse getCDByID(long codCD){
        return cdRepository.findById(codCD)
        .map(CDMapper::toResponse)
        .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "CD not found"));
    }

    public CDResponse getCDByName(String nameCD){
        return cdRepository.findByName(nameCD)
        .map(CDMapper::toResponse)
        .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "CD not found"));
    }

    public List<CDResponse> getAllCDs(){
        return cdRepository.findAll().stream()
        .map(CDMapper::toResponse)
        .collect(Collectors.toList());
    }

    // posts

    public CDResponse include(IncludeCDRequest request){
        CentroDistribuicao cd = CDMapper.toEntity(request);

        cdRepository.save(cd);

        return CDMapper.toResponse(cd);
    }
}
