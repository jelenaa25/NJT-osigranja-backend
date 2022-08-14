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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @Min(value = 1, message = "Povrsina stana mora biti veca od nule")
    private BigDecimal povrsinaStana;
    @Min(value = 1, message = "Vrednost po KvM mora biti veca od nule.")
    private BigDecimal vrednostPoKvM;
    @Min(value = 1, message = "Gradjevinska vrednost mora biti veca od nule")
    private BigDecimal gradjevinskaVrednost;
    private BigDecimal ukupnaPremija;
    private Date datumOD;
    private Date datumDO;
    private int agentOsiguranja;
    @NotEmpty(message = "Polisa mora imati bar jednu stavku.")
    @NotNull(message = "Polisa mora imati bar jednu stavku.")
    private List<StavkaPoliseDto> stavke;
}
