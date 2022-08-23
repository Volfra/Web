package co.edu.poli.act1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act1.model.Auto;
import co.edu.poli.act1.model.GroupQuery;
import co.edu.poli.act1.model.IGroupQuery;

public interface AutoRepository extends JpaRepository<Auto, Integer>{

	//JPQL
	@Query ("FROM Auto WHERE marca LIKE %?1% AND modelo = ?2")
	List<Auto> filterMarca1 (String s, int m);
	
	//SQL
	@Query (value="SELECT * FROM concesionario WHERE modelo > ?1",nativeQuery = true)
	List<Auto> filterMarca2 (int m);
	
	//JPQL
	//Class GroupQuery constructor with attributes
	@Query ("SELECT new co.edu.poli.act1.model.GroupQuery(modelo, count(modelo)) FROM Auto group by modelo")
	List<GroupQuery> groupModelo1 ();
	
	//SQL
	//Interface IGroupQuery only signatures (getCantidad and getModelo)
	@Query (value="SELECT c.modelo as modelo, count(c.modelo) as cantidad FROM concesionario as c group by c.modelo",nativeQuery = true)
	List<IGroupQuery> groupModelo2 ();

}
