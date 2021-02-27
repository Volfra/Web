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
		
	/*
	 * @Autowired 
	 * public BookController(BookRepository BookRepository) {
	 * 	super(); 
	 * 	this.BookRepository = BookRepository; 
	 * }
	 */

	@GetMapping("/Books")
	public List<Book> getAllBooks() {
		// The BookRepository is already injected and you can use it
		return bookRepository.findAll();
	}
	
	@GetMapping("/Books/{id}")
	public Book getBookById(@PathVariable Long id) { 
		Book Book =  bookRepository.findById(id).get();
		return Book;
	}
	
	@PostMapping("/Books")
	public Book createBook(@RequestBody Book Book) {
		return bookRepository.save(Book);
	}
	
	@PutMapping("/Books/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book BookNew) {
		Book Book = bookRepository.findById(id).get();

		Book.setAuthor(BookNew.getAuthor());
		Book.setCountry(BookNew.getCountry());
		Book.setImageLink(BookNew.getImageLink());
		Book.setLanguage(BookNew.getLanguage());
		Book.setLink(BookNew.getLink());
		Book.setPages(BookNew.getPages());
		Book.setTitle(BookNew.getTitle());
		Book.setYear(BookNew.getYear());
		Book.setCd(BookNew.getCd());
		Book.setEditorial(BookNew.getEditorial());
		
		bookRepository.save(Book);
		return Book;
	}
	
	@DeleteMapping("/Books/{id}")
	public Book deleteBook(@PathVariable Long id) {
		Book Book = bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		return Book;
	}
	
	//Query
	@GetMapping("/Bookss/{s}")
	public List<Book> getfindByCountry(@PathVariable String s) {
		return bookRepository.findByLanguage(s);
	}
	
	//Load List of Books
	@PostMapping("/BooksL")
	public String createBookList(@RequestBody BookList books) {
		
		for (Iterator<Book> iterator = books.getBooks().iterator(); iterator.hasNext();) {
			bookRepository.save(iterator.next());
		}
		
		return "done";
	}	
}