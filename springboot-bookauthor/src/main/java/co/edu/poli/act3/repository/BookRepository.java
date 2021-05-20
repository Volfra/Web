package co.edu.poli.act3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.act3.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
