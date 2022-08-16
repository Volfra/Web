package co.edu.poli.act1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act1.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, Integer>{

	//JPQL
	@Query ("FROM Auto WHERE marca LIKE %?1% AND modelo = ?2")
	List<Auto> filterMarca1 (String s, int m);
	
	//SQL
	@Query (value="SELECT marca, placa FROM concesionario WHERE modelo > ?1",nativeQuery = true)
	List<Auto> filterMarca2 (int m);
	
}
