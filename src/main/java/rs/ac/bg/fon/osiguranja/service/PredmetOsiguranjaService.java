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
import rs.ac.bg.fon.osiguranja.dto.PredmetOsiguranjaDto;
import rs.ac.bg.fon.osiguranja.mapper.PredmetOsiguranjaMapper;
import rs.ac.bg.fon.osiguranja.model.PredmetOsiguranja;
import rs.ac.bg.fon.osiguranja.repository.PredmetOsiguranjaRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class PredmetOsiguranjaService {
    private PredmetOsiguranjaRepository predmetOsiguranjaRepository;
    private PredmetOsiguranjaMapper predmetOsiguranjaMapper;

    public PredmetOsiguranjaService(PredmetOsiguranjaRepository predmetOsiguranjaRepository, PredmetOsiguranjaMapper predmetOsiguranjaMapper) {
        this.predmetOsiguranjaRepository = predmetOsiguranjaRepository;
        this.predmetOsiguranjaMapper = predmetOsiguranjaMapper;
    }
    
    @Transactional
    public PredmetOsiguranjaDto kreirajPredmetOsiguranja(PredmetOsiguranjaDto p) {
        return predmetOsiguranjaMapper.toDto(predmetOsiguranjaRepository.save(predmetOsiguranjaMapper.toEntity(p)));
    }

    public List<PredmetOsiguranjaDto> vratiSvePredmete() {
        List<PredmetOsiguranja> p = predmetOsiguranjaRepository.findAll();
        return p.stream().map((pp) -> {
            return predmetOsiguranjaMapper.toDto(pp);
        }).collect(Collectors.toList());
    }
    
}
