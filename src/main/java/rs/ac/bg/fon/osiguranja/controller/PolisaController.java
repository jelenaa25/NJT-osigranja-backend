/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.osiguranja.service.PolisaService;

/**
 *
 * @author Korisnik
 */
@RestController
public class PolisaController {
    @Autowired
    private PolisaService polisaService;
}
