/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.osiguranja.dto.PolisaDto;
import rs.ac.bg.fon.osiguranja.dto.StavkaPoliseDto;
import rs.ac.bg.fon.osiguranja.mapper.PolisaMapper;
import rs.ac.bg.fon.osiguranja.mapper.StavkaPoliseMapper;
import rs.ac.bg.fon.osiguranja.model.Polisa;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;
import rs.ac.bg.fon.osiguranja.repository.PolisaRepository;
import rs.ac.bg.fon.osiguranja.repository.StavkaPoliseRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class PolisaService {

    private final PolisaRepository polisaRepository;
    private final PolisaMapper polisaMapper;

    private final StavkaPoliseService stavkaPoliseService;

    public PolisaService(PolisaRepository polisaRepository, PolisaMapper polisaMapper, StavkaPoliseService stavkaPoliseService) {
        this.polisaRepository = polisaRepository;
        this.polisaMapper = polisaMapper;
        this.stavkaPoliseService = stavkaPoliseService;
    }

    @Transactional
    public boolean kreirajPolisu(PolisaDto p) {
        System.out.println("ZA CUVANJE POLISA: ");
       // Polisa cuv = polisaMapper.toEntity(p);
       // System.out.println("---------"+cuv);
       // System.out.println("Stavke za cuvanje:---"+cuv.getStavkePolise());
       // PolisaDto a1 = polisaMapper.toDto(polisaRepository.save(polisaMapper.toEntity(p)));
       /* System.out.println("a1 polisaid:" + a1.getPolisaID());
        p.getStavke().forEach((e) -> {
            e.setPolisaID(a1.getPolisaID());
            System.out.println("E:" + e);
            // stavkaPoliseRepository.save(stavkaPoliseMapper.toEntity(e));
            stavkaPoliseService.kreirajStavku(e);
        });*/
        //return a1;
        
        polisaRepository.save(polisaMapper.toEntity(p));
        
        return true;
    }

    public List<PolisaDto> vratiSvePolise() {
        List<Polisa> p = polisaRepository.findAll();
        System.out.println("POLISE: " + p.size());
        return p.stream().map((pp) -> {
            return polisaMapper.toDto(pp);
        }).collect(Collectors.toList());

        // return polisaRepository.findAll();
    }

    @Transactional
    public boolean obrisiPolisu(int id) throws Exception {
        System.out.println("IDpolise:"+id);
       // List<StavkaPolise> optionalStavke = stavkaPoliseService.findAllById(id);
      //  if (optionalStavke != null) {
        //    System.out.println("BrStavki:"+optionalStavke.size());
          //  stavkaPoliseService.obrisiStavke(id);

       // }
        /*
        Optional<Polisa> optionalPolisa = polisaRepository.findById(id);
        if (!optionalPolisa.isPresent()) {
            throw new Exception("Polisa sa id =  " + id + " ne postoji.");
        }*/
        System.out.println("BrisanjePOLISEEEEEEEE");
        //System.out.println("OpPolisa:"+optionalPolisa.get());
       //polisaRepository.deleteByPolisaID(id);
       
       polisaRepository.deleteById(id);
        return true;
    }
}
