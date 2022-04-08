package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act3.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	//Spring Data Derived findBy Query Methods (prefix findBy)
	//Retrieve all records from the database based on the Author
	//https://www.websparrow.org/spring/spring-data-derived-findby-query-methods-example
	//List<Book> findByAuthor (String s);
	
	//JPQL
	//@Query ("FROM Book WHERE author = ?1")
	//List<Book> findByAuthor1 (String s);
	
	//SQL
	@Query (value="SELECT id, name, author FROM books WHERE author = ?1",nativeQuery = true)
	List<Book> findByAuthor2 (String s);
	
	
}
