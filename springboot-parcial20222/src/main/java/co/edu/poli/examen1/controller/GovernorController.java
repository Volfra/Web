package co.edu.poli.examen1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.examen1.model.Governor;
import co.edu.poli.examen1.repository.GovernorRepository;

@RestController
@RequestMapping("/api/v1")
public class GovernorController {
	
	@Autowired
	private GovernorRepository governorRepository;
	
	@PostMapping("/governors")
	public String saveStates (@RequestBody List<Governor> governorsList) {
		governorRepository.saveAll(governorsList);	
		return "done";
	}

}
