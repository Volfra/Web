package co.edu.poli.act2.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act2.model.Book;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

	private HashMap<String,Book> books;

	public BookController() {
		books = new HashMap<String,Book>();
	}

	/* URL
	 * 127.0.0.1:8080/api/v1/get?idBook=978-607-7773-17-7
	 */
	@GetMapping("/book")
	public Book getBook(@RequestParam("idBook") String idBook) {
		return books.get(idBook);
	}

	/* URL
	 * 127.0.0.1:8080/api/v1/gets
	 */
	@GetMapping("/books")
	public HashMap<String,Book> getBooks() {
		return books;
	}

	/* URL 
	 * 127.0.0.1:8080/api/v1/post
	 * JSON
	 * {
	 * 		"isbn" : "978-607-7773-17-7",
	 * 		"name" : "La hojarasca",
	 * 		"author" : "Gabriel Garcia Marquez"
	 * }
	 */
	@PostMapping("/book")
	public String postBook(@RequestBody Book book) {
		int before = books.size(); 
		books.put(book.getIsbn(), book);
		return "Inserted. Size books before "+ before + " now "+ books.size();
	}

	/* URL 
	 * 127.0.0.1:8080/api/v1/postall
	 * JSON
	 * [{
	 * 		"isbn" : "978-607-7773-17-7",
	 * 		"name" : "La hojarasca",
	 * 		"author" : "Gabriel Garcia Marquez"
	 * },
	 * {
	 * 		"isbn" : "978-99961-46-12-1",
	 * 		"name" : "El principito",
	 * 		"author" : "Antoine de Saint-Exupéry"
	 * }
	 * ]
	 */
	@PostMapping("/bookl")
	public String saveListCustomers(@RequestBody List<Book> Lbooks) {
		int before = books.size(); 		 
        for (Book b : Lbooks) 
            books.put(b.getIsbn(), b);
		return "Inserted. Size books before "+ before + " now "+ books.size();
	}

	/* URL 
	 * 127.0.0.1:8080/api/v1/book/978-607-7773-17-7
	 * JSON
	 * {
	 * 		"isbn" : "978-607-7773-17-7",
	 * 		"name" : "Cien años de soledad",
	 * 		"author" : "Gabriel Garcia Marquez"
	 * }
	 */	
	@PutMapping("/book/{idBook}")
	public String putBook(@PathVariable String isbnBook, @RequestBody Book book) {
		books.replace(isbnBook, book);
		return "Modified";
	}

	/* URL 
	 * 127.0.0.1:8080/api/v1/book/978-607-7773-17-7
	 */
	@DeleteMapping("/book/{idBook}")
	public String deleteBook(@PathVariable String isbnBook) {
		try {
			books.remove(isbnBook);
		} catch (Exception e) {
			return "Error delete";
		}
		return "Deleted";
	}

}
