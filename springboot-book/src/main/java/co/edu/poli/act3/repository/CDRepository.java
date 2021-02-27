package co.edu.poli.act3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.act3.model.CD;

@Repository
public interface CDRepository extends JpaRepository<CD, String> {
	
	
}
