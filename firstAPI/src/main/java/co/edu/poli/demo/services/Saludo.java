package co.edu.poli.demo.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap1/")
public class Saludo {
	
	@GetMapping("/saludos")
	public String hola() {
		return "Hello World";
	}

}
