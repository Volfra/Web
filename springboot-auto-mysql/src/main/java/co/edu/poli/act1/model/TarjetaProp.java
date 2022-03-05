package co.edu.poli.act1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarjetas")
public class TarjetaProp {
		
	@Id
	private String id;
	private String fecha;
	private String ciudad;
	
	@OneToOne
	@JoinColumn(name="auto_id", unique=true)
	private Auto auto;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public TarjetaProp() {
	}

	public TarjetaProp(String id, String fecha, String ciudad) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.ciudad = ciudad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
