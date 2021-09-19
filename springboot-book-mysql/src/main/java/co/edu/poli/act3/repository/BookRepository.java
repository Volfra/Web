package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act3.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query ("FROM Book WHERE author = ?1")
	List<Book> findByAuthor (String s);
	
}
