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

import co.edu.poli.p1.model.Agreement;
import co.edu.poli.p1.repository.AgreementRepository;

@RestController
@RequestMapping("/api/v1/")
public class AgreementController {

	@Autowired
	private AgreementRepository agreementRepository;

	@GetMapping("/Agreements")
	public List<Agreement> getAllAgreements() {
		// The AgreementRepository is already injected and you can use it
		return agreementRepository.findAll();
	}
	
	@GetMapping("/Agreements/{id}")
	public Agreement getAgreementById(@PathVariable Long id) { 
		Agreement Agreement =  agreementRepository.findById(id).get();
		return Agreement;
	}
	
	@PostMapping("/Agreements")
	public ResponseEntity<Object> createAgreement(@RequestBody Agreement Agreement) {
		try { 
			Agreement b = agreementRepository.save(Agreement);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	@PostMapping("/Agreementsl")
	public ResponseEntity<Object> createAgreement(@RequestBody List<Agreement> Agreement) {
		try { 
			List<Agreement> b = agreementRepository.saveAll(Agreement);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	
	@PutMapping("/Agreements/{id}")
	public Agreement updateAgreement(@PathVariable Long id, @RequestBody Agreement AgreementNew) {
		Agreement Agreement = agreementRepository.findById(id).get();

		Agreement.setDate(AgreementNew.getDate());
		Agreement.setObs(AgreementNew.getObs());
		Agreement.setCountries(AgreementNew.getCountries());
		
		agreementRepository.save(Agreement);
		return Agreement;
	}
	
	
	@DeleteMapping("/Agreements/{id}")
	public Agreement deleteAgreement(@PathVariable Long id) {
		Agreement Agreement = agreementRepository.findById(id).get();
		agreementRepository.deleteById(id);
		return Agreement;
	}
	
}
