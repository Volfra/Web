package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act3.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, String> {

	//JPQL
	@Query("FROM Auto WHERE marca = ?1")
	List<Auto> findByMarca(String aut);

	//SQL native
	@Query(value="SELECT * FROM autos WHERE model BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Auto> findByModelo(int b, int e);
	
}