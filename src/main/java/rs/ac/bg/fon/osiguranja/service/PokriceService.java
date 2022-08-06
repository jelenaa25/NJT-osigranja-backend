/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.dto.PokriceDto;
import rs.ac.bg.fon.osiguranja.mapper.PokriceMapper;
import rs.ac.bg.fon.osiguranja.model.Pokrice;
import rs.ac.bg.fon.osiguranja.repository.PokriceRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class PokriceService {
    private final PokriceRepository pokriceRepository;
    private final PokriceMapper pokriceMapper;

    public PokriceService(PokriceRepository pokriceRepository, PokriceMapper pokriceMapper) {
        this.pokriceRepository = pokriceRepository;
        this.pokriceMapper = pokriceMapper;
    }
    
    @Transactional
    public PokriceDto kreirajPokrice(PokriceDto p) {
        return pokriceMapper.toDto(pokriceRepository.save(pokriceMapper.toEntity(p)));
    }
    public Optional<PokriceDto> nadjiPokrice(int id) {
        Optional<Pokrice> entity = pokriceRepository.findById(id);
        if (entity.isPresent()) {
            return Optional.of(pokriceMapper.toDto(entity.get()));
        }
        return Optional.empty();
    }
    public PokriceDto promeniPokriceById(int id, PokriceDto novo) throws Exception{
        Optional<PokriceDto> staro = nadjiPokrice(id);
        if (staro.isPresent()) {
            //return Optional.of(cityConverter.toDto(entity.get()));
            Pokrice p = pokriceMapper.toEntity(staro.get());
            Pokrice n = pokriceMapper.toEntity(novo);
            p.setNapomena(n.getNapomena());
            p.setNaziv(n.getNaziv());
            return pokriceMapper.toDto(pokriceRepository.save(p));
        }
        throw new Exception("Ne moze da se promeni pokrice jer ne postoji...");
    }

    public List<PokriceDto> vratiSvaPokrica() {
        List<Pokrice> p = pokriceRepository.findAll();
        return p.stream().map((pp) -> {
            return pokriceMapper.toDto(pp);
        }).collect(Collectors.toList());
    }
    
    
    
}
