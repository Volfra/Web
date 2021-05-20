package co.edu.poli.act3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import co.edu.poli.act3.model.Author;
import co.edu.poli.act3.repository.BookRepository;
import co.edu.poli.act3.repository.AuthorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class BookController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		// The BookRepository is already injected and you can use it
		return bookRepository.findAll();
	}

	@GetMapping("/books/{isbn}")
	public Book getBookById(@PathVariable Long isbn) { 
		Book book =  bookRepository.findById(isbn).get();
		return book;
	}
	
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/books/{isbn}")
	public Book updateBook(@PathVariable Long isbn, @RequestBody Book bookNew) {
		Book bookdb = bookRepository.findById(isbn).get();

		bookdb.setIsbn(bookNew.getIsbn());
		bookdb.setName(bookNew.getName());
		bookdb.setPublishDate(bookNew.getPublishDate());
		bookdb.setDataSetAuthors(bookNew.getDataSetAuthors());
		
		bookRepository.save(bookdb);
		return bookdb;
	}
	
	@DeleteMapping("/books/{isbn}")
	public Book deleteBook(@PathVariable Long isbn) {
		Book bookdb = bookRepository.findById(isbn).get();
		bookdb.setDataSetAuthors(null);
		bookRepository.delete(bookdb);
		return bookdb;
	} 
	
	@PutMapping("/books/{isbn}/{id}")
	public Book associate(@PathVariable Long isbn, @PathVariable Long id) {
		
		Book book =  bookRepository.findById(isbn).get();
		Author author = authorRepository.findById(id).get();
		
		book.getDataSetAuthors().add(author);
		author.getDataSetBooks().add(book);
		
		bookRepository.save(book);
		authorRepository.save(author);
		
		return book;
	}
	
}
