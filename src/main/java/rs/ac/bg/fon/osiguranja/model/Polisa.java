/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import java.math.BigDecimal;
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
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "polisa")
public class Polisa implements Entitet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PolisaID")
    private int polisaID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KlijentID", referencedColumnName = "KlijentID")
    private Klijent klijent;
    @Column(name = "PovrsinaStana")
    private BigDecimal povrsinaStana;
    @Column(name = "VrednostPoKvM")
    private BigDecimal vrednostPoKvM;
    @Column(name = "GradjevinskaVrednost")
    private BigDecimal gradjevinskaVrednost;
    @Column(name = "UkupnaPremija")
    private BigDecimal ukupnaPremija;
    @Column(name = "DatumOd")
    private Date datumOD;
    @Column(name = "DatumDo")
    private Date datumDO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    private Agent agentOsiguranja;
    @OneToMany(mappedBy = "polisa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StavkaPolise> stavkePolise;
}
