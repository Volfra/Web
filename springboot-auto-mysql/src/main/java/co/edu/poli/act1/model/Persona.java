package co.edu.poli.act1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="personas")
public class Persona {

	@Id
	private String cc;
	
	private String nombre;
	
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<TarjetaProp> tarjetaProp;
	
	public Persona() {
	}

	public Persona(String cc, String nombre) {
		super();
		this.cc = cc;
		this.nombre = nombre;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<TarjetaProp> getTarjetaProp() {
		return tarjetaProp;
	}

	public void setTarjetaProp(Set<TarjetaProp> tarjetaProp) {
		this.tarjetaProp = tarjetaProp;
	}
	
}
