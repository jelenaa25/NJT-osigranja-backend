/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.service;

import org.springframework.stereotype.Service;
import rs.ac.bg.fon.osiguranja.model.Agent;
import rs.ac.bg.fon.osiguranja.repository.AgentRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class AgentService {
    
    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
    
    public Agent loadUserByUsername(String username) throws Exception {
        Agent optionalUser = agentRepository.findAgentByUsername(username);
        if (optionalUser == null) {
            return null;
        }
        return optionalUser;
    }

    public Agent loadUserByUsernameAndPassword(String username, String password) throws Exception {
        Agent optionalUser = agentRepository.findAgentByUsernameAndPassword(username, password);
        if (optionalUser == null) {
            throw new Exception("User with username = " + username + " and password does not exist.");
        }
        return optionalUser;
    }
    
}
