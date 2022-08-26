/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Korisnik
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class AgentDto implements Dto{
    int id;
    //@NotBlank(message = "Username je obavezno.")
    String username;
    //@NotBlank(message = "Ime je obavezno.")
    String ime;
    //@NotBlank(message = "Prezime je obavezno.")
    String prezime;
    String token;
    //@NotBlank(message = "Uloga je obavezna.")
   
}
