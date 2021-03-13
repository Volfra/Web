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
import co.edu.poli.parcial1.model.Localizacion;
import co.edu.poli.parcial1.repository.DocumentoRepository;
import co.edu.poli.parcial1.repository.LocalizacionRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class LocalizacionController{

	// Tells the application context to inject an instance of LocalizacionRespository here
	@Autowired
	private LocalizacionRepository localizacionRepository;

	@Autowired
	private DocumentoRepository documentoRepository;

	@GetMapping("/Localizacions")
	public List<Localizacion> getAllLocalizacions() {
		// The LocalizacionRepository is already injected and you can use it
		return localizacionRepository.findAll();
	}
	
	@GetMapping("/Localizacions/{id}")
	public Localizacion getLocalizacionById(@PathVariable Long id) { 
		Localizacion Localizacion =  localizacionRepository.findById(id).get();
		return Localizacion;
	}
	
	@PostMapping("/Localizacions")
	public Localizacion createLocalizacion(@RequestBody Localizacion Localizacion) {
		return localizacionRepository.save(Localizacion);
	}
	
	@PutMapping("/Localizacions/{id}")
	public Localizacion updateLocalizacion(@PathVariable Long id, @RequestBody Localizacion LocalizacionNew) {
		Localizacion localizacion = localizacionRepository.findById(id).get();

		localizacion.setId(LocalizacionNew.getId());
		localizacion.setDescripcion(LocalizacionNew.getDescripcion());

		localizacionRepository.save(localizacion);
		return localizacion;
	}
	
	@DeleteMapping("/Localizacions/{id}")
	public Localizacion deleteLocalizacion(@PathVariable Long id) {
		Localizacion localizacion = localizacionRepository.findById(id).get();
		localizacionRepository.deleteById(id);
		return localizacion;
	}
	
	@PutMapping("/Localizacions/{loc}/{doc}")
	public Localizacion associate(@PathVariable Long loc, @PathVariable int doc) {
		
		Localizacion localizacion = localizacionRepository.findById(loc).get();
		Documento documento =  documentoRepository.findById(doc).get();
		
		documento.getLocalizaciones().add(localizacion);
		localizacion.getDocumentos().add(documento);
		
		localizacionRepository.save(localizacion);
		documentoRepository.save(documento);
		
		return localizacion;
	}
		
}