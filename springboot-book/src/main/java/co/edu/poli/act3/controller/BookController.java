package co.edu.poli.act3.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act3.model.Book;
import co.edu.poli.act3.model.BookList;
import co.edu.poli.act3.repository.BookRepository;

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
	public Book getBookById(@PathVariable Integer id) { 
		Book book =  bookRepository.findById(id).get();
		return book;
	}
	
	@PostMapping("/books")
	public Book createBoook(@RequestBody Book employee) {
		return bookRepository.save(employee);
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book bookNew) {
		Book bookdb = bookRepository.findById(id).get();

		bookdb.setIsbn(bookNew.getIsbn());
		bookdb.setName(bookNew.getName());
		bookdb.setAuthor(bookNew.getAuthor());
		
		bookRepository.save(bookdb);
		return bookdb;
	}
	
	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable Integer id) {
		Book bookdb = bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		return bookdb;
	}
	
	//Query
	@GetMapping("/bookss/{s}")
	public List<Book> getfindByAuthor(@PathVariable String s) {
		return bookRepository.findByAuthor(s);
	}

	
	//Load List of Books
	@PostMapping("/booksL")
	public String createEmployeeList(@RequestBody BookList books) {
		
		for (Iterator<Book> iterator = books.getBooks().iterator(); iterator.hasNext();) {
			bookRepository.save(iterator.next());
		}
		
		return "done";
	}
	
	
}
