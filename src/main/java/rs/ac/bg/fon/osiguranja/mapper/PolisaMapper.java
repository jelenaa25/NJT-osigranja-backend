/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.model.Polisa;

/**
 *
 * @author Korisnik
 */
@Component
public class PolisaMapper implements GenericMapper<PolisaDto, Polisa>{

    @Override
    public Polisa toEntity(PolisaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PolisaDto toDto(Polisa entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
