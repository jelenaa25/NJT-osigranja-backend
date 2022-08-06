/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.dto.KlijentDto;
import rs.ac.bg.fon.osiguranja.mapper.KlijentMapper;
import rs.ac.bg.fon.osiguranja.model.Klijent;
import rs.ac.bg.fon.osiguranja.repository.KlijentRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class KlijentService {
    
    private final KlijentRepository klijentRepository;
    private final KlijentMapper klijentMapper;

    public KlijentService(KlijentRepository klijentRepository, KlijentMapper klijentMapper) {
        this.klijentRepository = klijentRepository;
        this.klijentMapper = klijentMapper;
    }
 
    @Transactional
    public KlijentDto kreirajKlijenta(KlijentDto p) {
        return klijentMapper.toDto(klijentRepository.save(klijentMapper.toEntity(p)));
    }

    public List<KlijentDto> vratiSveKlijente() {
        
        List<Klijent> p = klijentRepository.findAll();
        return p.stream().map((pp) -> {
            return klijentMapper.toDto(pp);
        }).collect(Collectors.toList());
    }
    
}
