package co.edu.poli.p1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.p1.model.Continent;
import co.edu.poli.p1.repository.ContinentRepository;


@RestController
@RequestMapping("/api/v1/")
public class ContinentController {

	@Autowired
	private ContinentRepository continentRepository;

	@GetMapping("/Continents")
	public List<Continent> getAllContinents() {
		// The ContinentRepository is already injected and you can use it
		return continentRepository.findAll();
	}
	
	@GetMapping("/Continents/{id}")
	public Continent getContinentById(@PathVariable String id) { 
		Continent Continent =  continentRepository.findById(id).get();
		return Continent;
	}
	
	@PostMapping("/Continents")
	public ResponseEntity<Object> createContinent(@RequestBody Continent Continent) {
		try { 
			Continent b = continentRepository.save(Continent);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	@PostMapping("/Continentsl")
	public ResponseEntity<Object> createCountries(@RequestBody List<Continent> Countries) {
		try { 
			List<Continent> b = continentRepository.saveAll(Countries);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	
	@PutMapping("/Continents/{id}")
	public Continent updateContinent(@PathVariable String id, @RequestBody Continent ContinentNew) {
		Continent Continent = continentRepository.findById(id).get();

		Continent.setName(ContinentNew.getName());
		Continent.setQtyCountries(ContinentNew.getQtyCountries());

		continentRepository.save(Continent);
		return Continent;
	}
	
	
	@DeleteMapping("/Continents/{id}")
	public Continent deleteContinent(@PathVariable String id) {
		Continent Continent = continentRepository.findById(id).get();
		continentRepository.deleteById(id);
		return Continent;
	}
	
}