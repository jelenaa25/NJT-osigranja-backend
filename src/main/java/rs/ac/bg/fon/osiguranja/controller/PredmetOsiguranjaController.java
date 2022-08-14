/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.PredmetOsiguranjaDto;
import rs.ac.bg.fon.osiguranja.service.PredmetOsiguranjaService;

/**
 *
 * @author Korisnik
 */
@RestController
public class PredmetOsiguranjaController {
    
    private final PredmetOsiguranjaService predmetOsiguranjaService;

    public PredmetOsiguranjaController(PredmetOsiguranjaService predmetOsiguranjaService) {
        this.predmetOsiguranjaService = predmetOsiguranjaService;
    }
    
    @PostMapping("/predmet")
    public ResponseEntity<Object> kreirajPredmetOsiguranja(@RequestBody @Valid PredmetOsiguranjaDto p) throws Exception {
        try {
            return ResponseEntity.ok(predmetOsiguranjaService.kreirajPredmetOsiguranja(p));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    
    @GetMapping("/predmet")
    public List<PredmetOsiguranjaDto> vratiSvePredmete() throws Exception {
        return predmetOsiguranjaService.vratiSvePredmete();
    }
    
    
    
    
    
    
}
