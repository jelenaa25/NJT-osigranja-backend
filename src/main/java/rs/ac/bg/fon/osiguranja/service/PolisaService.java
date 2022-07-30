/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.repository.PolisaRepository;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class PolisaService {
    @Autowired
    private PolisaRepository polisaRepository;

    public Polisa kreirajPolisu(Polisa p) {

        //validacija TODO
        
        return polisaRepository.save(p);

    }

    public List<Polisa> vratiSvePolise() {
        return polisaRepository.findAll();
    }

    public boolean obrisiPolisu(int id) throws Exception{

           polisaRepository.deleteById(id);
           return true;
    }
}
