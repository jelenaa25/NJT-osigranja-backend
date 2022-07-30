/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.osiguranja.repository.PolisaRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class PolisaService {
    @Autowired
    private PolisaRepository polisaRepository;
}
