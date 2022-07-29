/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class PredmetOsiguranja implements Entitet{
    @Id
    @Column(name = "PredmetID")
    private int predmetID;
    @Column(name = "Naziv")
    private String naziv;
    @Column(name = "Napomena")
    private String napomena;
}