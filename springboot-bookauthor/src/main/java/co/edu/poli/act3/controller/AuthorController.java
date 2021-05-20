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

import co.edu.poli.act3.model.Author;
import co.edu.poli.act3.repository.AuthorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class AuthorController {

	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		// The BookRepository is already injected and you can use it
		return authorRepository.findAll();
	}

	@GetMapping("/authors/{id}")
	public Author getAuthorById(@PathVariable Long id) { 
		Author author =  authorRepository.findById(id).get();
		return author;
	}
	
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return authorRepository.save(author);
	}

	@PutMapping("/authors/{id}")
	public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorNew) {
		Author authordb = authorRepository.findById(id).get();

		authordb.setId(authorNew.getId());
		authordb.setName(authorNew.getName());
		authordb.setNationality(authorNew.getNationality());
		authordb.setDataSetBooks(authorNew.getDataSetBooks());
		
		authorRepository.save(authordb);
		return authordb;
	}
	
	@DeleteMapping("/authors/{id}")
	public Author deleteAuthor(@PathVariable Long id) {
		Author authordb = authorRepository.findById(id).get();
		authorRepository.delete(authordb);
		return authordb;
	}

	
}
