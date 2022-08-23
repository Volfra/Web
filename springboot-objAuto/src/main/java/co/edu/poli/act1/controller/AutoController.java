package co.edu.poli.act1.controller;

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

import co.edu.poli.act1.model.Auto;
import co.edu.poli.act1.model.GroupQuery;
import co.edu.poli.act1.model.IGroupQuery;
import co.edu.poli.act1.repository.AutoRepository;

@RestController
@RequestMapping("/api/v1")
public class AutoController {

	@Autowired
	private AutoRepository autoRepository;
	
	@GetMapping("/auto")
	public List<Auto> getAutos () {
		return autoRepository.findAll();
	}

	@GetMapping("/autos/{idAuto}")
	public Auto getAuto (@PathVariable int idAuto) {
		Auto a = autoRepository.findById(idAuto).get();
		return a;
	}
	
	@PostMapping("/auto")
	public Auto saveAuto (@RequestBody Auto auto) {
		autoRepository.save(auto);	
		return auto;
	}
	
	@PostMapping("/autos")
	public String saveAutos (@RequestBody List<Auto> autosList) {
		autoRepository.saveAll(autosList);	
		return "done";
	}
	
	@PutMapping("/auto/{idAuto}")
	public Auto putAuto(@PathVariable int idAuto, @RequestBody Auto auto){
		
		Auto a = getAuto(idAuto);
		
		a.setMarca(auto.getMarca());
		a.setModelo(auto.getModelo());
		a.setColor(auto.getColor());
		a.setPlaca(auto.getPlaca());
		
		autoRepository.save(a);
		return a;
	}
	
	@DeleteMapping("/auto/{idAuto}")
	public Auto delAuto(@PathVariable int idAuto){
		Auto a = getAuto(idAuto);
		autoRepository.deleteById(idAuto);
		return a;
	}
	
	@GetMapping("/autoq1/{s}/{i}")
	public List<Auto> getAutosQuery1 (@PathVariable String s, @PathVariable int i) {
		return autoRepository.filterMarca1(s,i);
	}

	@GetMapping("/autoq2/{i}")
	public List<Auto> getAutosQuery2 (@PathVariable int i) {
		return autoRepository.filterMarca2(i);
	}

	@GetMapping("/autoq3")
	public List<GroupQuery> getAutosQuery3 () {
		return autoRepository.groupModelo1();
	}

	@GetMapping("/autoq4")
	public List<IGroupQuery> getAutosQuery4 () {
		return autoRepository.groupModelo2();
	}

}
