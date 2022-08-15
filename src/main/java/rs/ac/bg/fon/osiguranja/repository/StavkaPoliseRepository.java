/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.osiguranja.model.StavkaPolise;
import rs.ac.bg.fon.osiguranja.model.idclasses.StavkaPoliseId;

/**
 *
 * @author Korisnik
 */
@Repository
public interface StavkaPoliseRepository extends JpaRepository<StavkaPolise, StavkaPoliseId>{


   List<StavkaPolise> findAllByPolisa_polisaID(int polisa);

    public void deleteAllByPolisa_polisaID(int polisa);
    
   
   
    
}
