/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.mapper;

import rs.ac.bg.fon.osiguranja.dto.Dto;
import rs.ac.bg.fon.osiguranja.model.Entitet;


/**
 *
 * @author korisnik
 */
public interface GenericMapper<D extends Dto, E extends Entitet> {

    E toEntity(D dto);

    D toDto(E entity);
}
