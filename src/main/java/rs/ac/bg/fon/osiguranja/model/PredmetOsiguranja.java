/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "predmetosiguranja")
public class PredmetOsiguranja implements Entitet, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int predmetID;
    @Column(name = "Naziv")
    @NotBlank(message = "Naziv predmeta osiguranja je obavezan.")
    private String naziv;
    @Column(name = "Napomena")
    private String napomena;
}
