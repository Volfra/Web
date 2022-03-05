package co.edu.poli.t1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flores")
public class Iris {
	
	//Primary key
	@Id
	//auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	private double sepal_length;
	
	private double sepal_width;
	
	private double petal_length;
	
	private double petal_width;
	
	private String species;
	
	public Iris() {
	}

	public Iris(int id, double sepal_length, double sepal_width, double petal_length, double petal_width, String species) {
		super();
		this.id = id;
		this.sepal_length = sepal_length;
		this.sepal_width = sepal_width;
		this.petal_length = petal_length;
		this.petal_width = petal_width;
		this.species = species;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSepal_length() {
		return sepal_length;
	}

	public void setSepal_length(double sepal_length) {
		this.sepal_length = sepal_length;
	}

	public double getSepal_width() {
		return sepal_width;
	}

	public void setSepal_width(double sepal_width) {
		this.sepal_width = sepal_width;
	}

	public double getPetal_length() {
		return petal_length;
	}

	public void setPetal_length(double petal_length) {
		this.petal_length = petal_length;
	}

	public double getPetal_width() {
		return petal_width;
	}

	public void setPetal_width(double petal_width) {
		this.petal_width = petal_width;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}
