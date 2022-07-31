/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.mapper.PolisaMapper;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.repository.PolisaRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class PolisaService {
    
   
    private PolisaRepository polisaRepository;
    private PolisaMapper polisaMapper;

    public PolisaService(PolisaRepository polisaRepository, PolisaMapper polisaMapper) {
        this.polisaRepository = polisaRepository;
        this.polisaMapper = polisaMapper;
    }
    
    @Transactional
    public PolisaDto kreirajPolisu(PolisaDto p) {
        return polisaMapper.toDto(polisaRepository.save(polisaMapper.toEntity(p)));
    }
    
    @Transactional
    public List<PolisaDto> vratiSvePolise() {
        List<Polisa> p = polisaRepository.findAll();
        System.out.println("POLISE: "+p.size());
        if(p.get(0).getDatumOD() == null){
            System.out.println("NULLLL JEEEE...............................................");
        }
        return p.stream().map((pp) -> {
            return polisaMapper.toDto(pp);
        }).collect(Collectors.toList());
        
      
       // return polisaRepository.findAll();
    }

    @Transactional
    public boolean obrisiPolisu(int id) throws Exception{
           polisaRepository.deleteById(id);
           return true;
    }
}
