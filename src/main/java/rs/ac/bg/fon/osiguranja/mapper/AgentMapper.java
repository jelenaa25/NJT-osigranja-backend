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
        Agent a = new Agent();
        a.setAgentID(dto.getAgentID());
        a.setIme(dto.getIme());
        a.setPrezime(dto.getPrezime());
        a.setStrucnaSprema(dto.getStrucnaSprema());
        a.setUsername(dto.getUsername());
        return a;
    }

    @Override
    public AgentDto toDto(Agent entity) {
        AgentDto a = new AgentDto();
        a.setAgentID(entity.getAgentID());
        a.setIme(entity.getIme());
        a.setPrezime(entity.getPrezime());
        a.setStrucnaSprema(entity.getStrucnaSprema());
        a.setUsername(entity.getUsername());
        return a;
    }
    
}
