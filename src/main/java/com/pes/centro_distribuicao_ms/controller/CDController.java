package com.pes.centro_distribuicao_ms.controller;

import com.pes.centro_distribuicao_ms.controller.request.IncludeCDRequest;
import com.pes.centro_distribuicao_ms.controller.response.CDCodeResponse;
import com.pes.centro_distribuicao_ms.controller.response.CDResponse;
import com.pes.centro_distribuicao_ms.service.CDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cds")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearerAuth")
public class CDController {

    @Autowired
    private CDService cdService;

    @Operation(summary = "Get a CD or a full list of CDs.", description = "Return a specific CD by name or ID or the full list of the CDs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CD found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CDResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"error\": \"Invalid parameters\"}"))),
            @ApiResponse(responseCode = "404", description = "CD not found", content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"error\": \"CD not found\"}"))),
    })
    @GetMapping
    public ResponseEntity<?> getCD(@RequestParam(required = false) Long codCD, @RequestParam(required = false) String nameCD) {

        if (codCD != null) {
            CDResponse response = cdService.getCDByID(codCD);
            return ResponseEntity.ok(response);
        } else if (nameCD != null) {
            CDResponse response = cdService.getCDByName(nameCD);
            return ResponseEntity.ok(response);
        } else {
            List<CDResponse> responseList = cdService.getAllCDs();
            return ResponseEntity.ok(responseList);
        }
    }

    @Operation(summary = "Create a new CD.", description = "Create a new CD using the given parameters.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CD created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CDCodeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"error\": [\"Phone is required\",\n" + "\"Neighborhood is required\"]}")))
    })
    @PostMapping
    public CDCodeResponse include(@Valid @RequestBody IncludeCDRequest request) {
        return cdService.include(request);
    }
}
