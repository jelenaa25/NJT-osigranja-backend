/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.PokriceDto;
import rs.ac.bg.fon.osiguranja.model.Pokrice;

/**
 *
 * @author Korisnik
 */
@Component
public class PokriceMapper implements GenericMapper<PokriceDto, Pokrice>{

    @Override
    public Pokrice toEntity(PokriceDto dto) {
        Pokrice p = new Pokrice();
        p.setNapomena(dto.getNapomena());
        p.setNaziv(dto.getNaziv());
        p.setPokriceID(dto.getPokriceID());
        return p;
    }

    @Override
    public PokriceDto toDto(Pokrice entity) {
        PokriceDto p = new PokriceDto();
        p.setNapomena(entity.getNapomena());
        p.setNaziv(entity.getNaziv());
        p.setPokriceID(entity.getPokriceID());
        return p;
    }
    
}
