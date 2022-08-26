/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.dto.KlijentDto;
import rs.ac.bg.fon.osiguranja.model.Mesto;
import rs.ac.bg.fon.osiguranja.repository.MestoRepository;

/**
 *
 * @author Korisnik
 */
@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET})
public class MestoController {
    private final MestoRepository mestoRepository;

    public MestoController(MestoRepository mestoRepository) {
        this.mestoRepository = mestoRepository;
    }
    
    @GetMapping("/mesto")
    public List<Mesto> vratiMesta() throws Exception {
        return mestoRepository.findAll();
    }
}
