package co.edu.poli.act1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act1.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, Integer>{

	@Query ("FROM Auto WHERE marca LIKE %?1% AND modelo = ?2")
	List<Auto> filterMarca (String s, int a);
	
}
