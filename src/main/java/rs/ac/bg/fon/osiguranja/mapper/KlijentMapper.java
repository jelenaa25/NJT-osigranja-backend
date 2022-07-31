/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import rs.ac.bg.fon.osiguranja.dto.KlijentDto;
import rs.ac.bg.fon.osiguranja.model.Klijent;

/**
 *
 * @author Korisnik
 */
public class KlijentMapper implements GenericMapper<KlijentDto, Klijent>{

    @Override
    public Klijent toEntity(KlijentDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KlijentDto toDto(Klijent entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
