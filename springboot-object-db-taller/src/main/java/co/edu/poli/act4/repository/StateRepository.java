package co.edu.poli.act4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act4.model.ResultQ1;
import co.edu.poli.act4.model.ResultQ2;
import co.edu.poli.act4.model.State;

public interface StateRepository extends JpaRepository<State, String>{

	//JPQL
	@Query("FROM State WHERE capital_city like %?1%")
	List<State> findByCapitalCity(char letter);

	//SQL native
	@Query(value="SELECT state FROM states WHERE population BETWEEN ?1 AND ?2", nativeQuery = true)
	List<String> findByPopulation(int x, int y);

	//SQL native
	@Query(value="SELECT state, nickname, admission_number FROM states WHERE capital_city LIKE ?1%", nativeQuery = true)
	List<Object> q0(char c);	

	//JPQL
	@Query("SELECT new co.edu.poli.act4.model.ResultQ1 (state, nickname, admission_number) FROM State WHERE capital_city LIKE ?1%")
	List<ResultQ1> q1(char c);	
	
	//SQL native
	@Query(value="SELECT state, nickname, admission_number FROM states WHERE capital_city LIKE ?1%", nativeQuery = true)
	List<ResultQ2> q2(char c);	
}
