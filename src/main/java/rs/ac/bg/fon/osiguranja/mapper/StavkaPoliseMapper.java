/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.StavkaPoliseDto;
import rs.ac.bg.fon.osiguranja.model.Entitet;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;

/**
 *
 * @author Korisnik
 */
@Component

public class StavkaPoliseMapper implements GenericMapper<StavkaPoliseDto, StavkaPolise>{
    
    @Override
    public StavkaPolise toEntity(StavkaPoliseDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StavkaPoliseDto toDto(StavkaPolise entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
