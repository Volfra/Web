package co.edu.poli.t1.controller;

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

import co.edu.poli.t1.model.Iris;
import co.edu.poli.t1.repository.IrisRepository;

@RestController
@RequestMapping("/api/v1")
public class IrisController {

	@Autowired
	private IrisRepository irisRepository;
	
	@GetMapping("/iris")
	public List<Iris> getIriss () {
		return irisRepository.findAll();
	}

	@GetMapping("/iriss/{Iris}")
	public Iris getIris (@PathVariable int Iris) {
		return irisRepository.findById(Iris).get();
	}
	
	@PostMapping("/iris")
	public Iris saveIris (@RequestBody Iris iris) {
		irisRepository.save(iris);	
		return iris;
	}
	
	@PostMapping("/iriss")
	public String saveIriss (@RequestBody List<Iris> irissList) {
		irisRepository.saveAll(irissList);	
		return "done";
	}
	
	@PutMapping("/iris/{Iris}")
	public Iris putIris(@PathVariable int Iris, @RequestBody Iris iris){
		Iris a = irisRepository.findById(Iris).get();
		
		a.setPetal_length(iris.getPetal_length());
		a.setPetal_width(iris.getPetal_width());
		a.setSepal_length(iris.getSepal_length());
		a.setSepal_width(iris.getSepal_width());
		a.setSpecies(iris.getSpecies());
		
		return irisRepository.save(a);
	}
	
	@DeleteMapping("/iris/{Iris}")
	public String delIris(@PathVariable int Iris){
		irisRepository.deleteById(Iris);
		return "delete";
	}
	
	//2. Query JPQL
	@GetMapping("/irisq1/{s}")
	public List<Iris> getfindBySpecie(@PathVariable String s) {
		return irisRepository.findBySpecie(s);
	}

	//3. Query SQL
	@GetMapping("/irisq2/{a}/{b}")
	public List<Iris> getfindByPetalLength(@PathVariable double a, @PathVariable double b) {
		return irisRepository.findByPetalLength(a, b);
	}
}
