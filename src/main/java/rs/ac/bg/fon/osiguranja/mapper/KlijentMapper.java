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
//dodaj mestoRepositoryyy
    @Override
    public Klijent toEntity(KlijentDto dto) {
        Klijent k = new Klijent();
        k.setId(dto.getId());
        k.setImePrezime(dto.getImePrezime());
        //k.setMesto();
        return k;
    }

    @Override
    public KlijentDto toDto(Klijent entity) {
        KlijentDto k = new KlijentDto();
        k.setId(entity.getId());
        k.setImePrezime(entity.getImePrezime());
        k.setMesto(entity.getMesto().getPTT());
        return k;
    }
    
}
