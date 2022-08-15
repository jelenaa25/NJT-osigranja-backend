/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.StavkaPoliseDto;
import rs.ac.bg.fon.osiguranja.model.Entitet;
import rs.ac.bg.fon.osiguranja.model.Pokrice;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.model.PredmetOsiguranja;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;
import rs.ac.bg.fon.osiguranja.repository.PokriceRepository;
import rs.ac.bg.fon.osiguranja.repository.PolisaRepository;
import rs.ac.bg.fon.osiguranja.repository.PredmetOsiguranjaRepository;

/**
 *
 * @author Korisnik
 */
@Component

public class StavkaPoliseMapper implements GenericMapper<StavkaPoliseDto, StavkaPolise>{
    
  /*  private final PolisaRepository polisaRepository;
    private final PokriceRepository pokriceRepository;
    private final PredmetOsiguranjaRepository osiguranjaRepository;

    public StavkaPoliseMapper(PolisaRepository polisaRepository, PokriceRepository pokriceRepository, PredmetOsiguranjaRepository osiguranjaRepository) {
        this.polisaRepository = polisaRepository;
        this.pokriceRepository = pokriceRepository;
        this.osiguranjaRepository = osiguranjaRepository;
    }
    */
    @Autowired
    private static int rb = 1;
 
    @Override
    public StavkaPolise toEntity(StavkaPoliseDto dto) {
        StavkaPolise st = new StavkaPolise();
        st.setPremija(dto.getPremija());
        st.setProcenatAmortizacije(dto.getProcenatAmortizacije());
        st.setRb(rb++);
     //   st.setPolisa(polisaRepository.findById(dto.get));
       st.setSumaOsiguranja(dto.getSumaOsiguranja());
        st.setPokrice(new Pokrice(dto.getPokriceID(), "", ""));
        st.setPredmetOsiguranja(new PredmetOsiguranja(dto.getPredmetOsiguranjaID(), "", ""));
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
