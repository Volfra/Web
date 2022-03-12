package co.edu.poli.t1.model;

import java.util.List;

import javax.persistence.ElementCollection;
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

	/*
	{
        "sepal_length": 5.1,
        "sepal_width": 3.5,
        "petal_length": 1.4,
        "petal_width": 0.2,
        "species": "setosa",
         "examples": [
            "1",
            "2"
        ],
        "example": [
            "1",
            "2"
        ]
    }
    */
	//BLOB in MYSQL JSON Array
	private String[] examples;
	
	//New entity OneToOne JSON Array
	@ElementCollection
	private List<String> example;
	
	public List<String> getExample() {
		return example;
	}

	public void setExample(List<String> example) {
		this.example = example;
	}

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

	public String[] getExamples() {
		return examples;
	}

	public void setExamples(String[] examples) {
		this.examples = examples;
	}




}
