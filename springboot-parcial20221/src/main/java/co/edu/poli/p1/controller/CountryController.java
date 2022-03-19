package co.edu.poli.p1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.p1.model.Capital;
import co.edu.poli.p1.model.Continent;
import co.edu.poli.p1.model.Country;
import co.edu.poli.p1.repository.CapitalRepository;
import co.edu.poli.p1.repository.ContinentRepository;
import co.edu.poli.p1.repository.CountryRepository;


@RestController
@RequestMapping("/api/v1/")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ContinentRepository continentRepository;

	@Autowired
	private CapitalRepository capitalRepository;
	
	@GetMapping("/Countries")
	public List<Country> getAllCountrys() {
		// The CountryRepository is already injected and you can use it
		return countryRepository.findAll();
	}
	
	@GetMapping("/Countries/{iso}")
	public Country getCountryById(@PathVariable String iso) { 
		Country country =  countryRepository.findById(iso).get();
		return country;
	}
	
	@PostMapping("/Countries")
	public ResponseEntity<Object> createCountry(@RequestBody Country Country) {
		try { 
			Country b = countryRepository.save(Country);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	@PostMapping("/Countriesl")
	public ResponseEntity<Object> createCountries(@RequestBody List<Country> Countries) {
		try { 
			List<Country> b = countryRepository.saveAll(Countries);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	
	@PutMapping("/Countries/{iso}")
	public Country updateCountry(@PathVariable String iso, @RequestBody Country CountryNew) {
		Country country = countryRepository.findById(iso).get();

		country.setName(CountryNew.getName());
		country.setTld(CountryNew.getTld());
		country.setCapital(CountryNew.getCapital());
		country.setArea(CountryNew.getArea());
		
		countryRepository.save(country);
		return country;
	}
	
	
	@DeleteMapping("/Countries/{iso}")
	public Country deleteCountry(@PathVariable String iso) {
		Country country = countryRepository.findById(iso).get();
		countryRepository.deleteById(iso);
		return country;
	}
	
	@PutMapping("/Countries/{iso}/{id}")
	public String asociateCountry (@PathVariable String iso, @PathVariable String id) {
		Country country = countryRepository.findById(iso).get();
		Continent continent = continentRepository.findById(id).get();
		
		country.setContinent(continent);
		continent.getCountries().add(country);
		
		countryRepository.save(country);
		continentRepository.save(continent);
		
		return country.getName().getOfficial() + "->" + continent.getName();
	}
	
	@GetMapping("/Countriesq1/{from}/{to}/{id}")
	public List<String> query1 (@PathVariable int from, @PathVariable int to, @PathVariable String id) {
		return countryRepository.query1(from, to, id);
	}

	@GetMapping("/Countriesq2/{c}")
	public List<Capital> query2 (@PathVariable char c) {
		return capitalRepository.query2(c);
	}

}