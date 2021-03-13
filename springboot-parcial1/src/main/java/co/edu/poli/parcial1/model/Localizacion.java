package co.edu.poli.parcial1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Localizacion")
public class Localizacion {
	
	@Id
	@Column(name="Id")
	private long id;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable (name = "Localizacion_Documento", 
				joinColumns = { @JoinColumn(name = "Localizacion__ID") }, 
				inverseJoinColumns = { @JoinColumn (name = "Documento_ID") })
	private Set<Documento> documentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

}
