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

import co.edu.poli.parcial1.model.Documento;
import co.edu.poli.parcial1.repository.DocumentoRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DocumentoController {

	// Tells the application context to inject an instance of DocumentoRespository here
	@Autowired
	private DocumentoRepository documentoRepository;
		
	/*
	 * @Autowired 
	 * public DocumentoController(DocumentoRepository DocumentoRepository) {
	 * 	super(); 
	 * 	this.DocumentoRepository = DocumentoRepository; 
	 * }
	 */

	@GetMapping("/Documentos")
	public List<Documento> getAllDocumentos() {
		// The DocumentoRepository is already injected and you can use it
		return documentoRepository.findAll();
	}
	
	@GetMapping("/Documentos/{id}")
	public Documento getDocumentoById(@PathVariable int id) { 
		Documento Documento =  documentoRepository.findById(id).get();
		return Documento;
	}
	
	@PostMapping("/Documentos")
	public Documento createDocumento(@RequestBody Documento Documento) {
		return documentoRepository.save(Documento);
	}
	
	@PutMapping("/Documentos/{id}")
	public Documento updateDocumento(@PathVariable int id, @RequestBody Documento DocumentoNew) {
		Documento Documento = documentoRepository.findById(id).get();

		Documento.setTipo(DocumentoNew.getTipo());
		Documento.setDescripcion(DocumentoNew.getDescripcion());

		documentoRepository.save(Documento);
		return Documento;
	}
	
	@DeleteMapping("/Documentos/{id}")
	public Documento deleteDocumento(@PathVariable int id) {
		Documento Documento = documentoRepository.findById(id).get();
		documentoRepository.deleteById(id);
		return Documento;
	}
	
	/*
	@GetMapping("/Documentoss/{s}")
	public List<Documento> getfindByCountry(@PathVariable String s) {
		return documentoRepository.findByLanguage(s);
	}*/
	
}