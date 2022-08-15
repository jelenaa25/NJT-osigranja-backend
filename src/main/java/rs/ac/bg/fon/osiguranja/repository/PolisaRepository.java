/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.osiguranja.model.Polisa;

/**
 *
 * @author Korisnik
 */
@Repository
public interface PolisaRepository extends JpaRepository<Polisa, Integer>{
    void deleteByPolisaID(int poli);
}
