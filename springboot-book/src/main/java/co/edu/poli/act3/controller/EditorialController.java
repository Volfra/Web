package co.edu.poli.act3.controller;

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
import co.edu.poli.act3.model.Editorial;
import co.edu.poli.act3.repository.BookRepository;
import co.edu.poli.act3.repository.EditorialRepository;

@RestController 
@RequestMapping("/api/v1/")
public class EditorialController {

	@Autowired
	private EditorialRepository editorialRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/Editorials")
	public List<Editorial> getAllEditorials() {
		// The EditorialRepository is already injected and you can use it
		return editorialRepository.findAll();
	}
	
	@GetMapping("/Editorials/{nit}")
	public Editorial getEditorialById(@PathVariable String nit) { 
		Editorial Editorial =  editorialRepository.findById(nit).get();
		return Editorial;
	}
	
	@PostMapping("/Editorials")
	public Editorial createEditorial(@RequestBody Editorial Editorial) {
		return editorialRepository.save(Editorial);
	}

	@PutMapping("/Editorials/{nit}/{id}")
	public Editorial associate(@PathVariable String nit, @PathVariable Long id) {
		
		Editorial editorial = editorialRepository.findById(nit).get();
		Book book =  bookRepository.findById(id).get();
		
		book.setEditorial(editorial);
		editorial.getBook().add(book);
		
		editorialRepository.save(editorial);
		bookRepository.save(book);
		return editorial;
	}

	@PutMapping("/Editorials/{nit}")
	public Editorial updateEditorial(@PathVariable String nit, @RequestBody Editorial EditorialNew) {
		Editorial Editorial = editorialRepository.findById(nit).get();

		Editorial.setNit(EditorialNew.getNit());
		Editorial.setName(EditorialNew.getName());
		Editorial.setAddress(EditorialNew.getAddress());
		
		editorialRepository.save(Editorial);
		return Editorial;
	}
	
	@DeleteMapping("/Editorials/{nit}")
	public Editorial deleteEditorial(@PathVariable String nit) {
		Editorial Editorial = editorialRepository.findById(nit).get();
		editorialRepository.deleteById(nit);
		return Editorial;
	}
		
	
}