package co.edu.poli.first.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.first.model.Book;

@RestController
@RequestMapping("/msgs")
public class HelloRest {
	
	@GetMapping("/hello")
	public String reqHello() {
		return "Hello World";
	}

	@GetMapping("/welcome")
	public String reqWelcome() {
		return "Welcome WEB App";
	}
	
	@GetMapping("/helloname")
	public String sendReqParam(@RequestParam(name = "variable", defaultValue = "Student") String xyz) {
	    return "Hello " + xyz;
	}
	
	@GetMapping("/object")
	public Book reqBook() {
		return new Book(1, "La Hojarasca", "Gabriel Garcia Marquez");
	}
	
}