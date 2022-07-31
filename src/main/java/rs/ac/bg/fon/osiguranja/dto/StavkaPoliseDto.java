/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.dto;

import java.math.BigDecimal;
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
public class StavkaPoliseDto implements Dto{
    private int polisaID;
    private int rb;
    private int predmetOsiguranjaID;
    private int pokriceID;
    private BigDecimal sumaOsiguranja;
    private Integer procenatAmortizacije;
    private BigDecimal premija;  
}
