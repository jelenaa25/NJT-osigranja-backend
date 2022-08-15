/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.dto.StavkaPoliseDto;
import rs.ac.bg.fon.osiguranja.mapper.StavkaPoliseMapper;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;
import rs.ac.bg.fon.osiguranja.repository.StavkaPoliseRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class StavkaPoliseService {
    private final StavkaPoliseRepository stavkaPoliseRepository;
    private final StavkaPoliseMapper stavkaPoliseMapper;

    public StavkaPoliseService(StavkaPoliseRepository stavkaPoliseRepository, StavkaPoliseMapper stavkaPoliseMapper) {
        this.stavkaPoliseRepository = stavkaPoliseRepository;
        this.stavkaPoliseMapper = stavkaPoliseMapper;
    }
    
    @Transactional
    public StavkaPoliseDto kreirajStavku(StavkaPoliseDto p) {
        System.out.println("Uslo u kreiranje stavke...");
        System.out.println("Stavka: "+p);
        StavkaPolise nova = stavkaPoliseMapper.toEntity(p);
        System.out.println("ZA CUVANJE "+nova);
        StavkaPolise sacuvana = stavkaPoliseRepository.save(nova);
        System.out.println("SACUVANA: "+sacuvana);
        
        return stavkaPoliseMapper.toDto(sacuvana);
    }
   
    @Transactional
    public void obrisiStavke(int polisaID){
        stavkaPoliseRepository.deleteAllByPolisa_polisaID(polisaID);
    }

    List<StavkaPolise> findAllById(int id) {
        
        return stavkaPoliseRepository.findAllByPolisa_polisaID(id);
    }
    
}
