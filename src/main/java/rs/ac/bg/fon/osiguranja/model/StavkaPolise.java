/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "stavkapolise")
public class StavkaPolise implements Entitet{
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PolisaID", referencedColumnName = "PolisaID")
    private Polisa polisa;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "RB")
    private int rb;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PredmetID", referencedColumnName = "PredmetID")
    private PredmetOsiguranja predmetOsiguranja;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PokriceID", referencedColumnName = "PokriceID")
    private Pokrice pokrice;
    @Column(name  = "SumaOsiguranja")
    private BigDecimal sumaOsiguranja;
    @Column(name  = "ProcenatAmortizacije")
    private int procenatAmortizacije;
    @Column(name  = "Premija")
    private BigDecimal premija;  
}