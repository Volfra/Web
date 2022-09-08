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
	
	@Query ("FROM State WHERE population BETWEEN ?1 AND ?2")
	List<State> query3 (long min, long max);

	@Query (value="select state as est, nombre as gov "
			+ "from estados e, gobernadores g "
			+ "where e.code = g.state_id "
			+ "and e.capital_city = ?1",nativeQuery = true)
	List<IGov> query4 (String cap);
	
}
