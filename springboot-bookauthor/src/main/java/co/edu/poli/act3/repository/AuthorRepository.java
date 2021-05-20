package co.edu.poli.act3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.act3.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
