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

import co.edu.poli.act4.model.Country;
import co.edu.poli.act4.repository.CountryRepository;


@RestController
@RequestMapping("/api/v1/")
public class CountryController {
	
	// Tells the application context to inject an instance of CountryRespository here
	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("/countries")
	public List<Country> getAllCountrys() {
		// The CountryRepository is already injected and you can use it
		return countryRepository.findAll();
	}

	@GetMapping("/countries/{id}")
	public Country getCountryById(@PathVariable String id) {
		Country country = countryRepository.findById(id).get();
		return country;
	}

	@PostMapping("/countries")
	public Country createCountry(@RequestBody Country country) {
		return countryRepository.save(country);
	}

	// Load List of Countrys
	@PostMapping("/countriesL")
	public String createCountryList(@RequestBody List<Country> countries) {

		countryRepository.saveAll(countries);
		return "done";
	}

	@PutMapping("/countries/{id}")
	public Country updateCountry(@PathVariable String id, @RequestBody Country countryNew) {
		Country countrydb = countryRepository.findById(id).get();

		countrydb.setName(countryNew.getName());
		countrydb.setDenomAlt(countryNew.getDenomAlt());
		countrydb.setCoordinate(countryNew.getCoordinate());
		
		countryRepository.save(countrydb);
		return countrydb;
	}

	@DeleteMapping("/countries")
	public Country deleteCountry(@RequestParam("Code") String id) {
		Country countrydb = countryRepository.findById(id).get();
		countryRepository.delete(countrydb);
		return countrydb;
	}

}
