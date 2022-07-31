/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.dto;

import java.math.BigDecimal;
import java.util.Date;
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
    private String klijent;
    private BigDecimal povrsinaStana;
    private BigDecimal vrednostPoKvM;
    private BigDecimal gradjevinskaVrednost;
    private BigDecimal ukupnaPremija;
    private Date datumOD;
    private Date datumDO;
    private String agentOsiguranja;
}
