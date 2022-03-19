package co.edu.poli.p1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.p1.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
	
	/*
	 * Nombre de los países que está entre un rango de área y un continente determinado. 
	 * Los limites de área y el continente son digitados por el usuario. Hacer en JPQL.
	 */
	@Query("SELECT a.name.common "
			+ "FROM Country a, Continent b "
			+ "WHERE a.continent = b.id "
			+ "AND a.area BETWEEN ?1 AND ?2 "
			+ "AND b.name = ?3 ")
	public List<String> query1 (int from, int to, String continent);

}
