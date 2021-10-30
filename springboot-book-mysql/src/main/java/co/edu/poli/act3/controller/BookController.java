package co.edu.poli.act3.controller;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act3.model.Book;
import co.edu.poli.act3.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class BookController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		// The BookRepository is already injected and you can use it
		return bookRepository.findAll();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) { 
		
		if (bookRepository.existsById(id)) {
			Book book = bookRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(book);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
	
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable long id, @RequestBody Book bookNew) {
		Book bookdb = bookRepository.findById(id).get();

		bookdb.setIsbn(bookNew.getIsbn());
		bookdb.setName(bookNew.getName());
		bookdb.setAuthor(bookNew.getAuthor());
		
		bookRepository.save(bookdb);
		return bookdb;
	}
	
	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable long id) {
		Book bookdb = bookRepository.findById(id).get();
		bookRepository.delete(bookdb);
		return bookdb;
	}
	
	//Query
	@GetMapping("/bookss/{s}")
	public List<Book> getfindByAuthor(@PathVariable String s) {
		return bookRepository.findByAuthor(s);
	}

	
	//Load List of Books
	@PostMapping("/booksL")
	public String createBookList(@RequestBody List<Book> books) {
		bookRepository.saveAll(books);
		return "done";
	}
	
}
