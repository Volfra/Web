package co.edu.poli.parcial1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.parcial1.model.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String>{

}
