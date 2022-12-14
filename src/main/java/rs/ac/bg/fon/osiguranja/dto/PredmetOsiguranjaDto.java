/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.dto;

import javax.validation.constraints.NotBlank;
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
public class PredmetOsiguranjaDto implements Dto{
    
    private int sifra;
    @NotBlank(message = "Naziv predmeta osiguranja je obavezan.")
    private String naziv;
    private String napomena;
}
