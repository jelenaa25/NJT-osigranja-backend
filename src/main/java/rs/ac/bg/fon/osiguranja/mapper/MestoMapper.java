/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.MestoDto;
import rs.ac.bg.fon.osiguranja.model.Mesto;

/**
 *
 * @author Korisnik
 */
@Component
public class MestoMapper implements GenericMapper<MestoDto, Mesto>{

    @Override
    public Mesto toEntity(MestoDto dto) {
        Mesto m = new Mesto();
        m.setNaziv(dto.getNaziv());
        m.setPTT(dto.getPTT());
        return m;
    }

    @Override
    public MestoDto toDto(Mesto entity) {
        MestoDto m = new MestoDto();
        m.setNaziv(entity.getNaziv());
        m.setPTT(entity.getPTT());
        return m;
    }
    
}
