/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.service.PolisaService;

/**
 *
 * @author Korisnik
 */
@RestController
public class PolisaController {
    @Autowired
    private PolisaService polisaService;
    
    @PostMapping("/polisa")
    public Polisa kreirajPolisu(@RequestBody Polisa p) throws Exception{
        return polisaService.kreirajPolisu(p);
    }
    
    @GetMapping("/polisa")
    public List<Polisa> vratiSvePolise()throws Exception{
      return polisaService.vratiSvePolise();
    }
    
    @DeleteMapping("/polisa{id}")
    public boolean obrisiPolisu(@PathVariable("id") int id ) throws Exception{
        return polisaService.obrisiPolisu(id);
    }
    
    
}
