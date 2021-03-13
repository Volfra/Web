package co.edu.poli.parcial1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.parcial1.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
