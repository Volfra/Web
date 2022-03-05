package co.edu.poli.t1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.t1.model.Iris;

public interface IrisRepository extends JpaRepository<Iris, Integer>{
	
	@Query ("FROM Iris WHERE species LIKE %?1%")
	List<Iris> findBySpecie (String s);

	@Query (value="SELECT id, sepal_length, sepal_width, petal_length, petal_width, species "
			+ "FROM flores WHERE petal_length BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Iris> findByPetalLength (double a, double b);
}
