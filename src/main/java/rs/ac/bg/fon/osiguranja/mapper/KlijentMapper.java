/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.osiguranja.dto.KlijentDto;
import rs.ac.bg.fon.osiguranja.model.Klijent;
import rs.ac.bg.fon.osiguranja.model.Mesto;
import rs.ac.bg.fon.osiguranja.repository.MestoRepository;

/**
 *
 * @author Korisnik
 */
@Component
@AllArgsConstructor
public class KlijentMapper implements GenericMapper<KlijentDto, Klijent>{
//dodaj mestoRepositoryyy
    private MestoRepository mestoRepository;
    
    @Override
    public Klijent toEntity(KlijentDto dto) {
        Klijent k = new Klijent();
        k.setJmbg(dto.getJmbg());
        k.setImePrezime(dto.getImePrezime());
        Mesto mm;
        mm = mestoRepository.findByNaziv(dto.getMesto());
        //k.setMesto(new Mesto(11000, "Beograd"));
        k.setMesto(mm);
        return k;
    }

    @Override
    public KlijentDto toDto(Klijent entity) {
        KlijentDto k = new KlijentDto();
        k.setJmbg(entity.getJmbg());
        k.setImePrezime(entity.getImePrezime());
        k.setMesto(entity.getMesto().getNaziv());
        return k;
    }
    
}
