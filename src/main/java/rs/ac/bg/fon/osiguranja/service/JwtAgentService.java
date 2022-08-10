/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.osiguranja.model.Agent;
import rs.ac.bg.fon.osiguranja.repository.AgentRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class JwtAgentService implements UserDetailsService{
   @Autowired
    private AgentService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            rs.ac.bg.fon.osiguranja.model.Agent user = userService.loadUserByUsername(username);

            if (user.getUsername().equals(username)) {
                return new User(user.getUsername(), user.getPassword(),
                        new ArrayList<>());
            } 
        } catch (Exception ex) {
            Logger.getLogger(JwtAgentService.class.getName()).log(Level.SEVERE, null, ex);
        }
                throw new UsernameNotFoundException("User not found with username: " + username);
    }
    
    
}
