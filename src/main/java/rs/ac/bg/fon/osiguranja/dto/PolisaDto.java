/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Korisnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolisaDto implements Dto{
    private int polisaID;
    private int klijent;
    private BigDecimal povrsinaStana;
    private BigDecimal vrednostPoKvM;
    private BigDecimal gradjevinskaVrednost;
    private BigDecimal ukupnaPremija;
    private Date datumOD;
    private Date datumDO;
    private int agentOsiguranja;
    private List<StavkaPoliseDto> stavke;
}
