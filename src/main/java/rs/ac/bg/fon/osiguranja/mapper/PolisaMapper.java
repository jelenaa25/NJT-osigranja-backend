/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.dto.StavkaPoliseDto;
import rs.ac.bg.fon.osiguranja.model.Agent;
import rs.ac.bg.fon.osiguranja.model.Klijent;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;

/**
 *
 * @author Korisnik
 */
@Component
public class PolisaMapper implements GenericMapper<PolisaDto, Polisa>{

    @Override
    public Polisa toEntity(PolisaDto dto) {
        Polisa p = new Polisa();
        p.setDatumDO(dto.getDatumDO());
        System.out.println("KL1: ");
        p.setKlijent(new Klijent(dto.getKlijent(), null, 0, null));
        System.out.println("Kl2: "+p.getKlijent());
        p.setDatumOD(dto.getDatumDO());
        p.setGradjevinskaVrednost(dto.getGradjevinskaVrednost());
        p.setPolisaID(dto.getPolisaID());
        p.setUkupnaPremija(dto.getUkupnaPremija());
        p.setVrednostPoKvM(dto.getVrednostPoKvM());
        p.setPovrsinaStana(dto.getPovrsinaStana());
        p.setAgentOsiguranja(new Agent(dto.getAgentOsiguranja(), null, null, null, null, null, null));
        //List<StavkaPolise> stavke = new ArrayList<>();
       // StavkaPoliseMapper mm = new StavkaPoliseMapper();
        /*for(StavkaPoliseDto s : dto.getStavke()){
           stavke.add(mm.toEntity(s));
        }
        p.setStavkePolise(stavke);*/
        for(StavkaPolise o: dto.getStavke()){
            o.setPolisa(new Polisa(dto.getPolisaID(), null, BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE, null, null, null, null));
        }
        p.setStavkePolise(dto.getStavke());
        return p;
    }

    @Override
    public PolisaDto toDto(Polisa entity) {
        PolisaDto p = new PolisaDto();
        p.setDatumDO(entity.getDatumDO());
        p.setAgentOsiguranja(entity.getAgentOsiguranja().getAgentID());
        p.setDatumOD(entity.getDatumOD());
        p.setGradjevinskaVrednost(entity.getGradjevinskaVrednost());
        p.setKlijent(entity.getKlijent().getId());
        p.setPolisaID(entity.getPolisaID());
        p.setPovrsinaStana(entity.getPovrsinaStana());
        p.setUkupnaPremija(entity.getUkupnaPremija());
        p.setVrednostPoKvM(entity.getVrednostPoKvM());
        p.setStavke(entity.getStavkePolise());
        return p;
    }
    
}
