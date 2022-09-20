package co.edu.poli.act1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act1.model.GroupQueryByAuto;
import co.edu.poli.act1.model.TarjetaProp;

public interface TarjetaPropRepository extends JpaRepository<TarjetaProp, String>{
	
	//JPQL
	//Class GroupQuery constructor with attributes
	@Query ("SELECT new co.edu.poli.act1.model.GroupQueryByAuto(auto, count(auto)) FROM TarjetaProp group by auto.getAuto()")
	List<GroupQueryByAuto> groupModelo3 ();

}
