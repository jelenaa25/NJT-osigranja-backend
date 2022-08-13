/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Korisnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agentosiguranja")
public class Agent implements Entitet {

    @Id
    private int agentID;
    @Column(name = "Ime")
    private String ime;
    @Column(name = "Prezime")
    private String prezime;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "StrucnaSprema")
    private String strucnaSprema;
    @Column(name = "Role")
    private String Role;
/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<? extends GrantedAuthority> l;
        l = (Collection<? extends GrantedAuthority>) (GrantedAuthority) () -> Role.name();
        return l;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }
*/
    
}
