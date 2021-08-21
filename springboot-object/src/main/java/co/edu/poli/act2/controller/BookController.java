package co.edu.poli.act2.controller;


import java.util.LinkedList;
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

	private List<Book> books;
	
	public BookController () {
		books = new LinkedList<>();
	}
	
	@PostMapping("/post")
    public Book postBook(@RequestBody Book book) {
        books.add(book); 
        return book;
    }
	
	@PutMapping("/put/{idBook}")
	 public Book putBook(@PathVariable int idBook, @RequestBody Book book){
	  books.set(idBook, book);
	  return book;
	 }
	
	@GetMapping("/get")
    public Book getBook(@RequestParam("idBook") int idBook) {
		if (books.size()>0)
			return books.get(idBook);
		else
			return null;
    }
	
	@PostMapping("/postall")
	public List<Book> saveListCustomers(@RequestBody List<Book> Lbooks) {
		books.addAll(Lbooks);
		return books;
	}
	
	@DeleteMapping("/delete/{idBook}")
    public String deleteBook(@PathVariable int idBook) {
        try {
           books.remove(idBook);
        } catch (Exception e) {
            return "Error";
        } 
        return "Done";
    }
	
}
