package com.pes.centro_distribuicao_ms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pes.centro_distribuicao_ms.controller.request.IncludeCDRequest;
import com.pes.centro_distribuicao_ms.controller.response.CDCodeResponse;
import com.pes.centro_distribuicao_ms.controller.response.CDResponse;
import com.pes.centro_distribuicao_ms.service.CDService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/v1/cds")
@CrossOrigin(origins = "*")
public class CDController {
    
    @Autowired
    private CDService cdService;

    //gets

    @GetMapping
    @ResponseStatus(OK)
    public ResponseEntity<?> getCD(@RequestParam(required = false) Long codCD,@RequestParam(required = false) String nameCD){
        
        if (codCD != null) {
            CDResponse response = cdService.getCDByID(codCD);
            return ResponseEntity.ok(response);
        } else if (nameCD != null) {
            CDResponse response = cdService.getCDByName(nameCD);
            return ResponseEntity.ok(response);
        } else{
            List<CDResponse> responseList = cdService.getAllCDs();
            return ResponseEntity.ok(responseList);
        }
    }
    
    /* @GetMapping
    @ResponseStatus(OK)
    public List<CDResponse> getAllCDs(){
        return cdService.getAllCDs();
        }
        
        @GetMapping("/id")
    @ResponseStatus(OK)
    public CDResponse getCDById(@RequestParam Long codCD){
        return cdService.getCDByID(codCD);
        }

    @GetMapping("/name")
    @ResponseStatus(OK)
    public CDResponse getCDByName(@RequestParam String nameCD){
        return cdService.getCDByName(nameCD);
    } */

    //posts

    @PostMapping
    @ResponseStatus(CREATED)
    public CDCodeResponse include(@Valid @RequestBody IncludeCDRequest request){
        return cdService.include(request);
    }

    
}
