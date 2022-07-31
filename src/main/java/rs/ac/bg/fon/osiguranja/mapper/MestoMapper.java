/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import rs.ac.bg.fon.osiguranja.dto.MestoDto;
import rs.ac.bg.fon.osiguranja.model.Mesto;

/**
 *
 * @author Korisnik
 */
public class MestoMapper implements GenericMapper<MestoDto, Mesto>{

    @Override
    public Mesto toEntity(MestoDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MestoDto toDto(Mesto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
