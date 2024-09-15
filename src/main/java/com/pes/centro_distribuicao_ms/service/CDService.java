package com.pes.centro_distribuicao_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import com.pes.centro_distribuicao_ms.controller.CDResponse;
import com.pes.centro_distribuicao_ms.mapper.CDMapper;
import com.pes.centro_distribuicao_ms.repository.CDRepository;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;
import java.util.stream.Collectors;;

public class CDService {
    
    @Autowired
    private CDRepository cdRepository;

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
}
