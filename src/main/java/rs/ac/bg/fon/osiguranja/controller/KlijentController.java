/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.KlijentDto;
import rs.ac.bg.fon.osiguranja.dto.PokriceDto;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.service.KlijentService;

/**
 *
 * @author Korisnik
 */
@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class KlijentController {
    private final KlijentService klijentService;

    public KlijentController(KlijentService klijentService) {
        this.klijentService = klijentService;
    }
    
    @PostMapping("/klijent")
    public ResponseEntity<Object> kreirajKlijenta(@RequestBody @Valid KlijentDto p) throws Exception{
        try {
            System.out.println("KLDTOOO:  "+p);
            return ResponseEntity.ok(klijentService.kreirajKlijenta(p));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/klijent")
    public List<KlijentDto> vratiSveKlijente() throws Exception {
        return klijentService.vratiSveKlijente();
    }
    
    @GetMapping("/klijent/{id}")
    public ResponseEntity<Object> vratiKlijenta(@PathVariable int id) throws Exception {
        Optional<KlijentDto> entity = klijentService.nadjiKlijenta(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nepostojeci klijent...");
    }
 
    @GetMapping("klijent/spec/{kl}")
    public List<KlijentDto> nadjiKlijentaByName(@PathVariable String kl) { //vrati odredjeno pokrice
        List<KlijentDto> entity = klijentService.nadjiKlByName(kl);
        return entity;
    }
    
    
}
