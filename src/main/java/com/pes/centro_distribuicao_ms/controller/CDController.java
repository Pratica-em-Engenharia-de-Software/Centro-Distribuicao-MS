package com.pes.centro_distribuicao_ms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pes.centro_distribuicao_ms.service.CDService;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/v1/cds")
@CrossOrigin(origins = "*")
public class CDController {
    
    @Autowired
    private CDService cdService;

    @GetMapping
    public List<CDResponse> getAllCDs(){
        return cdService.getAllCDs();
    }
    
    @GetMapping
    public CDResponse getCDById(@RequestParam Long codCD){
        return cdService.getCDByID(codCD);
    }

    @GetMapping
    public CDResponse getCDByName(@RequestParam String nameCD){
        return cdService.getCDByName(nameCD);
    }


}
