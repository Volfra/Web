package co.edu.poli.act1.controller;

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

import co.edu.poli.act1.model.TarjetaProp;
import co.edu.poli.act1.repository.TarjetaPropRepository;
import co.edu.poli.act1.model.Auto;
import co.edu.poli.act1.model.GroupQuery;
import co.edu.poli.act1.model.GroupQueryByAuto;
import co.edu.poli.act1.repository.AutoRepository;

@RestController
@RequestMapping("/api/v1")
public class TarjetaPropController {
	
	@Autowired
	private TarjetaPropRepository tarjetaPropRepository;
	
	@Autowired
	private AutoRepository autoRepository;
	
	@GetMapping("/tarjeta")
	public List<TarjetaProp> getTarjetas () {
		return tarjetaPropRepository.findAll();
	}

	@GetMapping("/tarjetas/{idTarjeta}")
	public TarjetaProp getTarjetaProp (@PathVariable String idTarjeta) {
		return tarjetaPropRepository.findById(idTarjeta).get();
	}
	
	@PostMapping("/tarjeta")
	public TarjetaProp saveTarjetaProp (@RequestBody TarjetaProp tarjetaProp) {
		tarjetaPropRepository.save(tarjetaProp);	
		return tarjetaProp;
	}
	
	@PostMapping("/tarjetas")
	public String saveTarjetas (@RequestBody List<TarjetaProp> tarjetaPropList) {
		tarjetaPropRepository.saveAll(tarjetaPropList);	
		return "done";
	}
	
	@PutMapping("/tarjeta/{idTarjeta}")
	public TarjetaProp putTarjetaProp(@PathVariable String idTarjeta, @RequestBody TarjetaProp tarjetaProp){
		
		TarjetaProp a = tarjetaPropRepository.findById(idTarjeta).get();
		
		a.setFecha(tarjetaProp.getFecha());
		a.setCiudad(tarjetaProp.getCiudad());
		a.setAuto(tarjetaProp.getAuto());
		
		tarjetaPropRepository.save(a);
		return a;
	}
	
	@DeleteMapping("/tarjeta/{idTarjeta}")
	public TarjetaProp delTarjetaProp(@PathVariable String idTarjeta){
		TarjetaProp a = tarjetaPropRepository.findById(idTarjeta).get();
		tarjetaPropRepository.deleteById(idTarjeta);
		return a;
	}
	
	
	@PutMapping("/tarjetas/{idT}/{idA}")
	public TarjetaProp associate(@PathVariable String idT, @PathVariable Integer idA) {
		
		TarjetaProp tarjetaProp = tarjetaPropRepository.findById(idT).get();
		Auto auto =  autoRepository.findById(idA).get();
		
		tarjetaProp.setAuto(auto);
				
		tarjetaPropRepository.save(tarjetaProp);
		return tarjetaProp;
	}
	
	@GetMapping("/tarjetaq5")
	public List<GroupQueryByAuto> getTarjetasQuery5 () {
		return tarjetaPropRepository.groupModelo3();
	}


}
