/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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
import rs.ac.bg.fon.osiguranja.repository.AgentRepository;
import rs.ac.bg.fon.osiguranja.repository.KlijentRepository;

/**
 *
 * @author Korisnik
 */
@Component
public class PolisaMapper implements GenericMapper<PolisaDto, Polisa>{

    private final AgentRepository agentRepository;
    private final KlijentRepository klijentRepository;

    public PolisaMapper(AgentRepository agentRepository, KlijentRepository klijentRepository) {
        this.agentRepository = agentRepository;
        this.klijentRepository = klijentRepository;
    }
    
    
    @Override
    public Polisa toEntity(PolisaDto dto) {
        Polisa p = new Polisa();
        p.setDatumDO(dto.getDatumDO());
        System.out.println("KL1: ");
        p.setKlijent(klijentRepository.findById(dto.getKlijent()).get());
        System.out.println("Kl2: "+p.getKlijent());
        p.setDatumOD(dto.getDatumDO());
        p.setGradjevinskaVrednost(dto.getGradjevinskaVrednost());

        p.setUkupnaPremija(dto.getUkupnaPremija());
        p.setVrednostPoKvM(dto.getVrednostPoKvM());
        p.setPovrsinaStana(dto.getPovrsinaStana());
        
        p.setAgentOsiguranja(agentRepository.findById(dto.getAgentOsiguranja()).get());
       List<StavkaPolise> stavke = new ArrayList<>();
       StavkaPoliseMapper mm = new StavkaPoliseMapper();

      List<StavkaPoliseDto> stIzDto = dto.getStavke();
      for(StavkaPoliseDto iz: stIzDto){
          StavkaPolise e = mm.toEntity(iz);
          e.setPolisa(p);
          stavke.add(e);
      }
      p.setStavkePolise(stavke);
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
        List<StavkaPoliseDto> stavke = new ArrayList<>();
        StavkaPoliseMapper mm = new StavkaPoliseMapper();
        for(StavkaPolise a: entity.getStavkePolise()){
            stavke.add(mm.toDto(a));
        }
        p.setStavke(stavke);
        return p;
    }
    
}
