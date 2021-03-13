package co.edu.poli.parcial1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Transaccion")
public class Transaccion {
	
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Fecha")
	private String fecha;
	
	@Column(name="Valor")
	private int valor;
	
	@ManyToOne
	@JoinColumn(name="Cuenta_ID")
	@JsonIgnore
	private Cuenta cuenta;
	
	@ManyToOne
	@JoinColumn(name="Documento_ID")
	@JsonIgnore
	private Documento documento;

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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}
