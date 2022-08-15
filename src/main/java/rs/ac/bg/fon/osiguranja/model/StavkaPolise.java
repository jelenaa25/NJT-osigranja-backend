/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rs.ac.bg.fon.osiguranja.model.idclasses.StavkaPoliseId;

/**
 *
 * @author Korisnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(StavkaPoliseId.class)
@Table(name = "stavkapolise")
public class StavkaPolise implements Entitet, Serializable{
    
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PolisaID", referencedColumnName = "PolisaID")
    private Polisa polisa;
    
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RB")
    private Integer rb;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PredmetID", referencedColumnName = "PredmetID")
    //@NotNull(message = "Predmet je obavezan.")
    private PredmetOsiguranja predmetOsiguranja;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PokriceID", referencedColumnName = "PokriceID")
    //@NotNull(message = "Pokrice je obavezno.")
    private Pokrice pokrice;
    @Column(name  = "SumaOsiguranja")
    private BigDecimal sumaOsiguranja;
    @Column(name  = "ProcenatAmortizacije")
    private Integer procenatAmortizacije;
    @Column(name  = "Premija")
    private BigDecimal premija;  
}
