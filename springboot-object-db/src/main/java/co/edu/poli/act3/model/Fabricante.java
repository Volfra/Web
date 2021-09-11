package co.edu.poli.act3.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
@Table(name="fabricantes")
public class Fabricante {

    /**
     * 
     */
	@Id
    private String nit;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String pais;
    
    /**
     * 
     */
    @OneToMany(mappedBy = "fabricante")
	@JsonIgnore
    private List <Auto> autos;
    
    /**
     * Default constructor
     */
    public Fabricante() {
    }
    
	public Fabricante(String nit, String nombre, String pais, List<Auto> autos) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.pais = pais;
		this.autos = autos;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
    
}