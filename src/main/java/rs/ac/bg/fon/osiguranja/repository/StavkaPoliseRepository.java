/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;

/**
 *
 * @author Korisnik
 */
@Repository
public interface StavkaPoliseRepository extends JpaRepository<StavkaPolise, Integer>{
    
}
