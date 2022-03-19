package co.edu.poli.p1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="continentes")
public class Continent {

	//Primary key
	@Id
	private String id;
	
	private String name;
	
	private int qtyCountries;
	
	@OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Country> countries;

	public Continent() {
		// TODO Auto-generated constructor stub
	}
	
	public Continent(String id, String name, int qtyCountries) {
		super();
		this.id = id;
		this.name = name;
		this.qtyCountries = qtyCountries;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQtyCountries() {
		return qtyCountries;
	}

	public void setQtyCountries(int qtyCountries) {
		this.qtyCountries = qtyCountries;
	}
	
	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}


}
