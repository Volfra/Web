package co.edu.poli.act3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act3.model.Duenio;
import co.edu.poli.act3.repository.DuenioRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DuenioController {

	// Tells the application context to inject an instance of AutoRespository here
	@Autowired
	private DuenioRepository duenioRepository;

	
	@PostMapping("/duenios")
	public Duenio createDuenio(@RequestBody Duenio duenio) {
		return duenioRepository.save(duenio);
	}
	
}
