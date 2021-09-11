package co.edu.poli.act3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="duenios")
public class Duenio {

    /**
     * 
     */
	@Id
    private String id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private char genero;
    
    @OneToOne(mappedBy = "duenio")
    @JsonIgnore
    private Auto auto;

	/**
     * Default constructor
     */
    public Duenio() {
    }

	public Duenio(String id, String nombre, char genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
    
    public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

}