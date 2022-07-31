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
        Polisa p = new Polisa();
        p.setDatumDO(dto.getDatumDO());
        p.setDatumOD(dto.getDatumDO());
        p.setGradjevinskaVrednost(dto.getGradjevinskaVrednost());
        p.setPolisaID(dto.getPolisaID());
        p.setUkupnaPremija(dto.getUkupnaPremija());
        p.setVrednostPoKvM(dto.getVrednostPoKvM());
        p.setPovrsinaStana(dto.getPovrsinaStana());
        return p;
    }

    @Override
    public PolisaDto toDto(Polisa entity) {
        PolisaDto p = new PolisaDto();
        p.setAgentOsiguranjaID(entity.getAgentOsiguranja().getAgentID());
        p.setDatumDO(entity.getDatumDO());
        p.setDatumOD(entity.getDatumOD());
        p.setGradjevinskaVrednost(entity.getGradjevinskaVrednost());
        p.setKlijentID(entity.getKlijent().getId());
        p.setPolisaID(entity.getPolisaID());
        p.setPovrsinaStana(entity.getPovrsinaStana());
        p.setUkupnaPremija(entity.getUkupnaPremija());
        p.setVrednostPoKvM(entity.getVrednostPoKvM());
        return p;
    }
    
}
