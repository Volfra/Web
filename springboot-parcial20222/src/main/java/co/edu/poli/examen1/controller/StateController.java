package co.edu.poli.examen1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.examen1.model.IState;
import co.edu.poli.examen1.model.State;
import co.edu.poli.examen1.repository.StateRepository;

@RestController
@RequestMapping("/api/v1")
public class StateController {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping("/states")
	public List<State> getStates () {
		return stateRepository.findAll();
	}

	@PostMapping("/states")
	public String saveStates (@RequestBody List<State> statesList) {
		stateRepository.saveAll(statesList);	
		return "done";
	}

	@GetMapping("/q1/{s}")
	public List<State> queryStates (@PathVariable String s) {
		return stateRepository.query1(s);
	}

	@GetMapping("/q2")
	public List<IState> queryGroup () {
		return stateRepository.query2();
	}

}
