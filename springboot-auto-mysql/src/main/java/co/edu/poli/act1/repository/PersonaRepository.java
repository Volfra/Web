package co.edu.poli.act1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.act1.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String>{

}
