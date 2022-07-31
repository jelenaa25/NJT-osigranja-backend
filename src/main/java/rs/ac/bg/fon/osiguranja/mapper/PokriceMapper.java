/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import rs.ac.bg.fon.osiguranja.dto.PokriceDto;
import rs.ac.bg.fon.osiguranja.model.Pokrice;

/**
 *
 * @author Korisnik
 */
public class PokriceMapper implements GenericMapper<PokriceDto, Pokrice>{

    @Override
    public Pokrice toEntity(PokriceDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PokriceDto toDto(Pokrice entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
