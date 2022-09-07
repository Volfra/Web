package co.edu.poli.examen1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.examen1.model.IState;
import co.edu.poli.examen1.model.State;

public interface StateRepository extends JpaRepository<State, String> {
	
	@Query ("FROM State s INNER JOIN s.governor g WHERE g.partido LIKE %?1%")
	List<State> query1 (String s);

	@Query (value="select sum(e.population) as suma, e.facebook_url as gface "
			+ " from estados as e group by e.facebook_url",nativeQuery = true)
	List<IState> query2 ();
	
}
