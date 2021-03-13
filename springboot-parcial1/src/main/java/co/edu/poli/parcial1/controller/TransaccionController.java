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
import co.edu.poli.parcial1.model.Documento;
import co.edu.poli.parcial1.model.QueryGroupBy;
import co.edu.poli.parcial1.model.Transaccion;
import co.edu.poli.parcial1.repository.CuentaRepository;
import co.edu.poli.parcial1.repository.DocumentoRepository;
import co.edu.poli.parcial1.repository.TransaccionRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class TransaccionController{

	// Tells the application context to inject an instance of TransaccionRespository here
	@Autowired
	private TransaccionRepository transaccionRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private DocumentoRepository documentoRepository;

	/*
	 * @Autowired 
	 * public TransaccionController(TransaccionRepository TransaccionRepository) {
	 * 	super(); 
	 * 	this.TransaccionRepository = TransaccionRepository; 
	 * }
	 */

	@GetMapping("/Transaccions")
	public List<Transaccion> getAllTransaccions() {
		// The TransaccionRepository is already injected and you can use it
		return transaccionRepository.findAll();
	}
	
	@GetMapping("/Transaccions/{id}")
	public Transaccion getTransaccionById(@PathVariable String id) { 
		Transaccion transaccion =  transaccionRepository.findById(id).get();
		return transaccion;
	}
	
	@PostMapping("/Transaccions")
	public Transaccion createTransaccion(@RequestBody Transaccion Transaccion) {
		return transaccionRepository.save(Transaccion);
	}
	
	@PutMapping("/Transaccions/{id}")
	public Transaccion updateTransaccion(@PathVariable String id, @RequestBody Transaccion transaccionNew) {
		Transaccion transaccion = transaccionRepository.findById(id).get();

		transaccion.setId(transaccionNew.getId());
		transaccion.setFecha(transaccionNew.getFecha());
		transaccion.setValor(transaccionNew.getValor());

		transaccionRepository.save(transaccion);
		return transaccion;
	}
	
	@DeleteMapping("/Transaccions/{id}")
	public Transaccion deleteTransaccion(@PathVariable String id) {
		Transaccion Transaccion = transaccionRepository.findById(id).get();
		transaccionRepository.deleteById(id);
		return Transaccion;
	}
	
	@PutMapping("/Transaccions/{id}/{cta}/{doc}")
	public Transaccion associate(@PathVariable String id, @PathVariable String cta, @PathVariable int doc) {
		
		Transaccion transaccion = transaccionRepository.findById(id).get();
		Cuenta cuenta = cuentaRepository.findById(cta).get();
		Documento documento =  documentoRepository.findById(doc).get();
		
		transaccion.setCuenta(cuenta);
		transaccion.setDocumento(documento);
		
		cuenta.getTransacciones().add(transaccion);
		documento.getTransacciones().add(transaccion);
		
		transaccionRepository.save(transaccion);
		cuentaRepository.save(cuenta);
		documentoRepository.save(documento);
		
		return transaccion;
	}
		
	@GetMapping("/Transaccions1")
	public List<QueryGroupBy> getsumaPorGrupo() {
		return transaccionRepository.sumaPorGrupo();
	}

	@GetMapping("/Transaccions2/{desc}")
	public List<Transaccion> getfiltroDocumento(@PathVariable String desc) {
		return transaccionRepository.filtroDocumento(desc);
	}

	@GetMapping("/Transaccions3")
	public List<Cuenta> getcuentasSinDoc795() {
		return transaccionRepository.cuentasSinDoc795();
	}
	
}