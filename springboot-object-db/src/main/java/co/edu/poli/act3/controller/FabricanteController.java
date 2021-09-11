package co.edu.poli.act3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.act3.model.Fabricante;
import co.edu.poli.act3.repository.FabricanteRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class FabricanteController {

	// Tells the application context to inject an instance of AutoRespository here
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@PostMapping("/fabs")
	public Fabricante createFabs(@RequestBody Fabricante fab) {
		return fabricanteRepository.save(fab);
	}
}