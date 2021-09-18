package co.edu.poli.act4.controller;

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

import co.edu.poli.act4.model.ResultQ1;
import co.edu.poli.act4.model.ResultQ2;
import co.edu.poli.act4.model.State;
import co.edu.poli.act4.repository.StateRepository;

@RestController
@RequestMapping("/api/v1/")
public class StateController {

	// Tells the application context to inject an instance of StateRespository here
	@Autowired
	private StateRepository stateRepository;

	@GetMapping("/states")
	public List<State> getAllStates() {
		// The StateRepository is already injected and you can use it
		return stateRepository.findAll();
	}

	@GetMapping("/states/{id}")
	public State getStateById(@PathVariable String id) {
		State state = stateRepository.findById(id).get();
		return state;
	}

	@PostMapping("/states")
	public State createState(@RequestBody State state) {
		return stateRepository.save(state);
	}

	// Load List of States
	@PostMapping("/statesL")
	public String createStateList(@RequestBody List<State> states) {

		stateRepository.saveAll(states);
		return "done";
	}

	@PutMapping("/states/{id}")
	public State updateState(@PathVariable String id, @RequestBody State stateNew) {
		State statedb = stateRepository.findById(id).get();

		statedb.setSlug(stateNew.getSlug());
		statedb.setCode(stateNew.getCode());
		statedb.setNickname(stateNew.getNickname());
		statedb.setWebsite(stateNew.getWebsite());
		statedb.setAdmission_date(stateNew.getAdmission_date());
		statedb.setAdmission_number(stateNew.getAdmission_number());
		statedb.setCapital_city(stateNew.getCapital_city());
		statedb.setCapital_url(stateNew.getCapital_url());
		statedb.setPopulation(stateNew.getPopulation());
		statedb.setPopulation_rank(stateNew.getPopulation_rank());
		statedb.setConstitution_url(stateNew.getConstitution_url());
		statedb.setState_flag_url(stateNew.getState_flag_url());
		statedb.setState_seal_url(stateNew.getState_seal_url());
		statedb.setMap_image_url(stateNew.getMap_image_url());
		statedb.setLandscape_background_url(stateNew.getLandscape_background_url());
		statedb.setSkyline_background_url(stateNew.getSkyline_background_url());
		statedb.setTwitter_url(stateNew.getTwitter_url());
		statedb.setFacebook_url(stateNew.getFacebook_url());

		stateRepository.save(statedb);
		return statedb;
	}

	@DeleteMapping("/states")
	public State deleteState(@RequestParam("Code") String id) {
		State statedb = stateRepository.findById(id).get();
		stateRepository.delete(statedb);
		return statedb;
	}

	// Query1
	@GetMapping("/statess/{s}")
	public List<State> getfindByCapitalCity (@PathVariable char s) {
		return stateRepository.findByCapitalCity(s);
	}

	// Query2
	@GetMapping("/statess/{b}/{e}")
	public List<String> getfindByPopulation(@PathVariable int b, @PathVariable int e) {
		return stateRepository.findByPopulation(b, e);
	}

	// Query3
	@GetMapping("/statess0/{c}")
	public List<Object> getQ0(@PathVariable char c) {
		return stateRepository.q0(c);
	}
	
	// Query4
	@GetMapping("/statess1/{c}")
	public List<ResultQ1> getQ1(@PathVariable char c) {
		return stateRepository.q1(c);
	}
	
	// Query5
	@GetMapping("/statess2/{c}")
	public List<ResultQ2> getQ2(@PathVariable char c) {
		return stateRepository.q2(c);
	}
}
