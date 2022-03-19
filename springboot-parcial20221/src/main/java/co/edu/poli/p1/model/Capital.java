package co.edu.poli.p1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="capitales")
public class Capital {

	//Primary key
	@Id
	//auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	private String name;
	
	private int population;
	
	private double density;
	
	@OneToOne(mappedBy = "capital")
	@JsonIgnore
	private Country country;

	public Capital() {
		// TODO Auto-generated constructor stub
	}
	
	public Capital(int id, String name, int population, double density) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.density = density;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}
	
}
