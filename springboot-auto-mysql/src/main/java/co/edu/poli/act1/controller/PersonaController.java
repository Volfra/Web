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

import co.edu.poli.act1.model.Persona;
import co.edu.poli.act1.repository.PersonaRepository;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/persona")
	public List<Persona> getPersonas() {
		return personaRepository.findAll();
	}

	@GetMapping("/personas/{idPersona}")
	public Persona getPersona(@PathVariable String idPersona) {
		Persona a = personaRepository.findById(idPersona).get();
		return a;
	}

	@PostMapping("/persona")
	public Persona savePersona(@RequestBody Persona persona) {
		personaRepository.save(persona);
		return persona;
	}

	@PostMapping("/personas")
	public String savePersona(@RequestBody List<Persona> personasList) {
		personaRepository.saveAll(personasList);
		return "done";
	}

	@PutMapping("/persona/{idPersona}")
	public Persona putPersona(@PathVariable String idPersona, @RequestBody Persona persona) {

		Persona a = personaRepository.findById(idPersona).get();

		a.setNombre(persona.getNombre());

		personaRepository.save(a);
		return a;
	}

	@DeleteMapping("/persona/{idPersona}")
	public Persona delPersona(@PathVariable String idPersona) {
		Persona a = personaRepository.findById(idPersona).get();
		personaRepository.deleteById(idPersona);
		return a;
	}


}
