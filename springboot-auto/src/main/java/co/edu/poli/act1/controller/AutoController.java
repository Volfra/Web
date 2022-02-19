package co.edu.poli.act1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act1.model.Auto;

@RestController
@RequestMapping("/api/v1")
public class AutoController {

	List<Auto> autos;
	
	public AutoController() {
		autos = new ArrayList<Auto>();
	}
	
	@GetMapping("/auto")
	public List<Auto> getAutos () {
		return autos;
	}

	@GetMapping("/autos/{idAuto}")
	public Auto getAuto (@PathVariable int idAuto) {
		Auto a = autos.get(idAuto);
		return a;
	}
	
	@PostMapping("/auto")
	public Auto saveAuto (@RequestBody Auto auto) {
		autos.add(auto);	
		return auto;
	}
	
	@PostMapping("/autos")
	public String saveAutos (@RequestBody List<Auto> autosList) {
				autos.addAll(autosList);	
				return "done";
	}
	
	@PutMapping("/auto/{idAuto}")
	public Auto putAuto(@PathVariable int idAuto, @RequestBody Auto auto){
		autos.set(idAuto, auto);
		return auto;
	}
	
	@DeleteMapping("/auto/{idAuto}")
	public Auto delAuto(@PathVariable int idAuto){
		return autos.remove(idAuto);
	}
	
}
