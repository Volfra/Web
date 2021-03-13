package co.edu.poli.parcial1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Documento")
public class Documento {
	
	@Id
	@Column(name="Tipo")
	private int tipo;
	
	@Column(name="Descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "documento",cascade = CascadeType.ALL)
    private Set<Transaccion> transacciones;
	
	@ManyToMany (mappedBy="documentos")
	@JsonIgnore
	private Set<Localizacion> localizaciones;

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Set<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Set<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public Set<Localizacion> getLocalizaciones() {
		return localizaciones;
	}

	public void setLocalizaciones(Set<Localizacion> localizaciones) {
		this.localizaciones = localizaciones;
	}

}
