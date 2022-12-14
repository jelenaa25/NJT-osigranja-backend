/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.PredmetOsiguranjaDto;
import rs.ac.bg.fon.osiguranja.model.PredmetOsiguranja;

/**
 *
 * @author Korisnik
 */
@Component
public class PredmetOsiguranjaMapper implements GenericMapper<PredmetOsiguranjaDto, PredmetOsiguranja>{

    @Override
    public PredmetOsiguranja toEntity(PredmetOsiguranjaDto dto) {
        PredmetOsiguranja  p = new PredmetOsiguranja();
        p.setNapomena(dto.getNapomena());
        p.setNaziv(dto.getNaziv());
        p.setPredmetID(dto.getSifra());
        return p;
    }

    @Override
    public PredmetOsiguranjaDto toDto(PredmetOsiguranja entity) {
        PredmetOsiguranjaDto p = new PredmetOsiguranjaDto();
        p.setNapomena(entity.getNapomena());
        p.setNaziv(entity.getNaziv());
        p.setSifra(entity.getPredmetID());
        return p;
    }
    
}
