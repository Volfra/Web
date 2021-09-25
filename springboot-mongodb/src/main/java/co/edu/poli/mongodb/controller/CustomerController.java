package co.edu.poli.mongodb.controller;

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

import co.edu.poli.mongodb.model.Customer;
import co.edu.poli.mongodb.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(tags = {"Class: CustomerController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/Customers")
	@ApiOperation(value = "*** Service Method Get All Customers ***", notes = "*** Get All Customers from MongoDB\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Customers!!! ***")})
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/Customers/{id}")
	public Customer getCustomerByID(@PathVariable String id) {
		return customerRepository.findById(id).get();
	}
	
	@PostMapping("/Customers")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@PostMapping("/CustomersList")
	public List<Customer> saveListCustomers(@RequestBody List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}
	
	@PutMapping("/Customers/{id}")
	public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
		
		Customer _customer = customerRepository.findById(id).get();
		
		_customer.setFirstname(customer.getFirstname());
		_customer.setLastname(customer.getLastname());
		_customer.setAddress(customer.getAddress());
		_customer.setAge(customer.getAge());
		_customer.setSalary(customer.getSalary());
		_customer.setMediosPago(customer.getMediosPago());
		_customer.setListaCompras(customer.getListaCompras());
		
		customerRepository.save(_customer);
		
		return _customer;
	}
	
	@DeleteMapping("/Customers/{id}")
	public Customer deleteCustomerById(@PathVariable String id) {
		Customer _customer = customerRepository.findById(id).get();
		customerRepository.deleteById(id);
		return _customer;
	}
	
	@DeleteMapping("/CustomersList")
	public void deleteAll() {
		customerRepository.deleteAll();
	}
	
	//Query
	@GetMapping("/CustomersQ1/{lastname}")
	public List<Customer> findCustomers1(@PathVariable String lastname){
		return customerRepository.findCustomersQ1(lastname);
	}

	//Query
	@GetMapping("/CustomersQ2")
	public List<Customer> findCustomers2(){
		return customerRepository.findCustomersQ2();
	}
	
	//Query
	@GetMapping("/CustomersQ3")
	public List<Customer> findCustomers3(){
		return customerRepository.findCustomersQ3();
	}
	
	//Query
	@GetMapping("/CustomersQ4")
	public List<Customer> findCustomers4(){
		return customerRepository.findCustomersQ4();
	}

	//Query
	@GetMapping("/CustomersQ5")
	public List<Customer> findCustomers5(){
		return customerRepository.findCustomersQ5();
	}
	
}