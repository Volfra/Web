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

import co.edu.poli.act4.model.Agreement;
import co.edu.poli.act4.repository.AgreementRepository;

@RestController
@RequestMapping("/api/v1/")
public class AgreementController {
	
	// Tells the application context to inject an instance of AgreementRespository here
	@Autowired
	private AgreementRepository agreementRepository;

	@GetMapping("/agreements")
	public List<Agreement> getAllAgreements() {
		// The AgreementRepository is already injected and you can use it
		return agreementRepository.findAll();
	}

	@GetMapping("/agreements/{id}")
	public Agreement getAgreementById(@PathVariable String id) {
		Agreement agreement = agreementRepository.findById(id).get();
		return agreement;
	}

	@PostMapping("/agreements")
	public Agreement createAgreement(@RequestBody Agreement agreement) {
		return agreementRepository.save(agreement);
	}

	// Load List of Agreements
	@PostMapping("/agreementsL")
	public String createAgreementList(@RequestBody List<Agreement> agreements) {

		agreementRepository.saveAll(agreements);
		return "done";
	}

	@PutMapping("/agreements/{id}")
	public Agreement updateAgreement(@PathVariable String id, @RequestBody Agreement agreementNew) {
		Agreement agreementdb = agreementRepository.findById(id).get();

		agreementdb.setDate(agreementNew.getDate());
		agreementdb.setObs(agreementNew.getObs());
		
		agreementRepository.save(agreementdb);
		return agreementdb;
	}

	@DeleteMapping("/agreements")
	public Agreement deleteAgreement(@RequestParam("Code") String id) {
		Agreement agreementdb = agreementRepository.findById(id).get();
		agreementRepository.delete(agreementdb);
		return agreementdb;
	}
}