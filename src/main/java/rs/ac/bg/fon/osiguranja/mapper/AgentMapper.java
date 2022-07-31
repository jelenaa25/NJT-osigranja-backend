/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import rs.ac.bg.fon.osiguranja.dto.AgentDto;
import rs.ac.bg.fon.osiguranja.model.Agent;

/**
 *
 * @author Korisnik
 */
public class AgentMapper implements GenericMapper<AgentDto, Agent>{

    @Override
    public Agent toEntity(AgentDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AgentDto toDto(Agent entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
