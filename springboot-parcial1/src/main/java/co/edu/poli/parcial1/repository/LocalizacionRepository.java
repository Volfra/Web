package co.edu.poli.parcial1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.parcial1.model.Localizacion;

@Repository
public interface LocalizacionRepository extends JpaRepository<Localizacion, Long>{

}
