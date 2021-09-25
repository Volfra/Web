package co.edu.poli.mongodb.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Customers")
public class Customer {
	
	//@Id
	private String customerId;
	
	private String firstname;
	
	private String lastname;
	
	private Integer age;
	
	private String address;
	
	@Field("Salario")
	private Double salary;
	
	private Map<String, String> mediosPago; 
	
	private List<Compras> listaCompras;
		
	public Customer() {
		
	}

	public Customer(String customerId, String firstname, String lastname, Integer age, String address, Double salary,
			Map<String, String> mediosPago, List<Compras> listaCompras) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.mediosPago = mediosPago;
		this.listaCompras = listaCompras;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<Compras> getListaCompras() {
		return listaCompras;
	}
	public void setListaCompras(List<Compras> listaCompras) {
		this.listaCompras = listaCompras;
	}
	public Map<String, String> getMediosPago() {
		return mediosPago;
	}
	public void setMediosPago(Map<String, String> mediosPago) {
		this.mediosPago = mediosPago;
	}
}