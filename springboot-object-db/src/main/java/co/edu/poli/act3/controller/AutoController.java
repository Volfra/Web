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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act3.model.Auto;
import co.edu.poli.act3.model.AutoList;
import co.edu.poli.act3.repository.AutoRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class AutoController {

	// Tells the application context to inject an instance of AutoRespository here
	@Autowired
	private AutoRepository autoRepository;

	@GetMapping("/autos")
	public List<Auto> getAllAutos() {
		// The AutoRepository is already injected and you can use it
		return autoRepository.findAll();
	}

	@GetMapping("/autos/{id}")
	public Auto getAutoById(@PathVariable String id) {
		Auto auto = autoRepository.findById(id).get();
		return auto;
	}

	@PostMapping("/autos")
	public Auto createAuto(@RequestBody Auto auto) {
		return autoRepository.save(auto);
	}

	@PutMapping("/autos/{id}")
	public Auto updateAuto(@PathVariable String id, @RequestBody Auto autoNew) {
		Auto autodb = autoRepository.findById(id).get();

		autodb.setPlaca(autoNew.getPlaca());
		autodb.setMarca(autoNew.getMarca());
		autodb.setModelo(autoNew.getModelo());
		autodb.setDuenio(autoNew.getDuenio());

		autoRepository.save(autodb);
		return autodb;
	}

	@DeleteMapping("/autos")
	public Auto deleteAuto(@RequestParam("Placa") String id) {
		Auto autodb = autoRepository.findById(id).get();
		autoRepository.delete(autodb);
		return autodb;
	}

	// Query1
	@GetMapping("/autoss/{s}")
	public List<Auto> getfindByMarca(@PathVariable String s) {
		return autoRepository.findByMarca(s);
	}

	// Query2
	@GetMapping("/autoss/{b}/{e}")
	public List<Auto> getfindByModelo(@PathVariable int b, @PathVariable int e) {
		return autoRepository.findByModelo(b,e);
	}
	
	// Load List of Autos
	@PostMapping("/autosL")
	public String createAutoList(@RequestBody List<Auto> autos) {

		autoRepository.saveAll(autos);
		return "done";
	}

	// Load List of Autos
	@PostMapping("/autosLL")
	public String createAutoList2(@RequestBody AutoList autos) {

		autoRepository.saveAll(autos.getAutos());
		return "done";
	}
}
