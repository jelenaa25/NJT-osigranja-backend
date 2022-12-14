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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.service.PolisaService;

/**
 *
 * @author Korisnik
 */
@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PolisaController {

    private final PolisaService polisaService;

    public PolisaController(PolisaService polisaService) {
        this.polisaService = polisaService;
    }
    @GetMapping("polisa/{id}")
    public ResponseEntity<Object> nadjiPolisu(@PathVariable int id) { //vrati odredjeno pokrice
        Optional<PolisaDto> entity = polisaService.nadjiPolisu(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nepostojeca polisa...");
    }
    
    @GetMapping("polisa/spec/{kl}")
    public List<PolisaDto> nadjiPolisuByKlijent(@PathVariable String kl) { //vrati odredjeno pokrice
        List<PolisaDto> entity = polisaService.nadjiPoliseByKlijent(kl);
        return entity;
    }
    
    @PostMapping("/polisa") //dodaj valid kasnijeee
    public ResponseEntity<Object> kreirajPolisu(@RequestBody @Valid PolisaDto p) throws Exception{
        try {
            return ResponseEntity.ok(polisaService.kreirajPolisu(p));
        } catch (Exception ex) {
           // ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    
    @GetMapping("/polisa")
    public List<PolisaDto> vratiSvePolise()throws Exception{
      return polisaService.vratiSvePolise();
    }
    //@DeleteMapping("/polisa/{id}")
   // @ResponseBody
    @RequestMapping( value = "/polisa/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public ResponseEntity<Object> doDelete(@PathVariable("id") int id ) throws Exception{
        
        try {
           return ResponseEntity.ok(polisaService.obrisiPolisu(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
       // return polisaService.obrisiPolisu(id);
    }
    
    
}
