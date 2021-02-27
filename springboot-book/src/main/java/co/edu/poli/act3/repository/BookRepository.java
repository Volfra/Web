package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.poli.act3.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("FROM Book WHERE language = ?1")
	List<Book> findByLanguage(String language);	
	
}
