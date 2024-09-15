package com.pes.centro_distribuicao_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pes.centro_distribuicao_ms.service.CDService;

@RestController
@RequestMapping("/v1/cds")
@CrossOrigin(origins = "*")
public class CDController {
    
    @Autowired
    private CDService cdService;

    public CDResponse getById(@RequestParam Long codCD){
        return cdService.getByID(codCD);
    }





}
