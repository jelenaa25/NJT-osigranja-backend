/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Korisnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "klijent")
public class Klijent implements Entitet, Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "KlijentID")
    private int id;
    @Column(name = "ImePrezime")
    @NotBlank(message = "Ime i prezime su obavezni.")
    private String imePrezime;
    @Column(name = "JMBG")
   
    private long jmbg;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Mesto", referencedColumnName = "PTT")
    //@NotNull(message = "Mesto mora biti uneto.")
    private Mesto mesto;
}
