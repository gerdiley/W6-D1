package it.epicode.w5.d3.le1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.w5.d3.le1.entities.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

}
