package co.edu.poli.parcial1.controller;

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

import co.edu.poli.parcial1.model.Cuenta;
import co.edu.poli.parcial1.repository.CuentaRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class CuentaController {

	// Tells the application context to inject an instance of CuentaRespository here
	@Autowired
	private CuentaRepository cuentaRepository;
		
	/*
	 * @Autowired 
	 * public CuentaController(CuentaRepository CuentaRepository) {
	 * 	super(); 
	 * 	this.CuentaRepository = CuentaRepository; 
	 * }
	 */

	@GetMapping("/Cuentas")
	public List<Cuenta> getAllCuentas() {
		// The CuentaRepository is already injected and you can use it
		return cuentaRepository.findAll();
	}
	
	@GetMapping("/Cuentas/{id}")
	public Cuenta getCuentaById(@PathVariable String id) { 
		Cuenta Cuenta =  cuentaRepository.findById(id).get();
		return Cuenta;
	}
	
	@PostMapping("/Cuentas")
	public Cuenta createCuenta(@RequestBody Cuenta Cuenta) {
		return cuentaRepository.save(Cuenta);
	}
	
	@PutMapping("/Cuentas/{id}")
	public Cuenta updateCuenta(@PathVariable String id, @RequestBody Cuenta CuentaNew) {
		Cuenta Cuenta = cuentaRepository.findById(id).get();

		Cuenta.setIdCliente(CuentaNew.getIdCliente());
		Cuenta.setNumero(CuentaNew.getNumero());
		Cuenta.setTipoCuenta(CuentaNew.getTipoCuenta());

		cuentaRepository.save(Cuenta);
		return Cuenta;
	}
	
	@DeleteMapping("/Cuentas/{id}")
	public Cuenta deleteCuenta(@PathVariable String id) {
		Cuenta Cuenta = cuentaRepository.findById(id).get();
		cuentaRepository.deleteById(id);
		return Cuenta;
	}
	
	/*
	@GetMapping("/Cuentass/{s}")
	public List<Cuenta> getfindByCountry(@PathVariable String s) {
		return cuentaRepository.findByLanguage(s);
	}*/
	
}