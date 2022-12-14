/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.PokriceDto;
import rs.ac.bg.fon.osiguranja.service.PokriceService;

/**
 *
 * @author Korisnik
 */
@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class PokriceController {

    private final PokriceService pokriceService;

    public PokriceController(PokriceService pokriceService) {
        this.pokriceService = pokriceService;
    }

    @GetMapping("/pokrice")
    public List<PokriceDto> vratiSvaPokrica() throws Exception {
        return pokriceService.vratiSvaPokrica();
    }

    @PostMapping("/pokrice")
    public ResponseEntity<Object> kreirajPokrice(@RequestBody  @Valid PokriceDto p) throws Exception {
        try {
            return ResponseEntity.ok(pokriceService.kreirajPokrice(p));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("pokrice/{id}")
    public ResponseEntity<Object> nadjiPokrice(@PathVariable int id) { //vrati odredjeno pokrice
        Optional<PokriceDto> entity = pokriceService.nadjiPokrice(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nepostojece pokrice...");
    }

    @PutMapping("pokrice/{id}")
    public ResponseEntity<Object> promeniPokriceById(@PathVariable("id") int id,
            @RequestBody @Valid PokriceDto pok) throws Exception {
        try {
            return ResponseEntity.ok(pokriceService.promeniPokriceById(id, pok));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        }
    }
}
