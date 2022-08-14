/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Entity
@Table(name = "polisa")
public class Polisa implements Entitet, Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PolisaID")
    private int polisaID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KlijentID", referencedColumnName = "KlijentID")
    @NotNull(message = "Klijent mora biti unet.")
    private Klijent klijent;
    @Column(name = "PovrsinaStana")
    @Min(value = 1, message = "Povrsina stana mora biti veca od nule")
    private BigDecimal povrsinaStana;
    @Column(name = "VrednostPoKvM")
    @Min(value = 1, message = "Vrednost po KvM mora biti veca od nule")
    private BigDecimal vrednostPoKvM;
    @Column(name = "GradjevinskaVrednost")
    @Min(value = 1, message = "Gradjevinska vrednost mora biti veca od nule")
    private BigDecimal gradjevinskaVrednost;
    @Column(name = "UkupnaPremija")
    private BigDecimal ukupnaPremija;
    @Column(name = "DatumOd")
    @JsonFormat
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datumOD;
    @Column(name = "DatumDo")
    @JsonFormat
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datumDO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @NotNull(message = "Agent mora biti unet.")
    private Agent agentOsiguranja;
    @OneToMany(mappedBy = "polisa", fetch = FetchType.LAZY)
    @NotEmpty(message = "Polisa mora imati bar jednu stavku.")
    @NotNull(message = "Polisa mora imati bar jednu stavku.")
    private List<StavkaPolise> stavkePolise;
    
}
