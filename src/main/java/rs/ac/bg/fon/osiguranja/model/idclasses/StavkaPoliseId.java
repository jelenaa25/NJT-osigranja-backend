/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model.idclasses;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Korisnik
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StavkaPoliseId implements Serializable{
    private int polisa;
    private int rb;
}
