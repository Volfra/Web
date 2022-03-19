package co.edu.poli.p1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.p1.model.Capital;

public interface CapitalRepository extends JpaRepository<Capital, Integer>{

	/* 
	 * Información de las capitales en el que el nombre del país contiene un caracter digitado por el usuario. 
	 * Hacer en SQL nativo.
	 */
	@Query(value="SELECT a.* "	
			   + "FROM capitales a, paises b, nombres c "
			   + "WHERE a.id = b.capital_id "
			   + "AND c.id = b.name_id "
			   + "AND c.common LIKE %?1% ", 
			   nativeQuery = true )
	public List<Capital> query2 (char c);

}
