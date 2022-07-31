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
        StavkaPolise st = new StavkaPolise();
        st.setPremija(dto.getPremija());
        st.setProcenatAmortizacije(dto.getProcenatAmortizacije());
        st.setRb(dto.getRb());
        st.setSumaOsiguranja(dto.getSumaOsiguranja());
        return st;
    }

    @Override
    public StavkaPoliseDto toDto(StavkaPolise entity) {
        StavkaPoliseDto std = new StavkaPoliseDto();
        std.setPokriceID(entity.getPokrice().getPokriceID());
        std.setPolisaID(entity.getPolisa().getPolisaID());
        std.setPredmetOsiguranjaID(entity.getPredmetOsiguranja().getPredmetID());
        std.setPremija(entity.getPremija());
        std.setProcenatAmortizacije(entity.getProcenatAmortizacije());
        std.setRb(entity.getRb());
        std.setSumaOsiguranja(entity.getSumaOsiguranja());
        return std;
    }
    
}
