/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.service.PolisaService;

/**
 *
 * @author Korisnik
 */
@RestController
public class PolisaController {

    private final PolisaService polisaService;

    public PolisaController(PolisaService polisaService) {
        this.polisaService = polisaService;
    }
    
    
    @PostMapping("/polisa")
    public ResponseEntity<Object> kreirajPolisu(@RequestBody PolisaDto p) throws Exception{
        try {
            return ResponseEntity.ok(polisaService.kreirajPolisu(p));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    
    @GetMapping("/polisa")
    public List<PolisaDto> vratiSvePolise()throws Exception{
      return polisaService.vratiSvePolise();
    }
    @DeleteMapping("/polisa/{id}")
    public ResponseEntity<Object> obrisiPolisu(@PathVariable("id") int id ) throws Exception{
        
        try {
           return ResponseEntity.ok(polisaService.obrisiPolisu(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
       // return polisaService.obrisiPolisu(id);
    }
    
    
}
