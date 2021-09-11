package co.edu.poli.act3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="autos")
public class Auto {

	//Primary key
	@Id
	@Column(name="ID")
	//auto_increment
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String placa;
	
	@Column(name="brand")
	private String marca;
	
	@Column(name="model")
	private int modelo;
	
	@OneToOne
	@JoinColumn(name="duenio_id")
	private Duenio duenio;
	
	@ManyToOne
	@JoinColumn(name="fabricante_id")
	private Fabricante fabricante;

	public Auto() {
		// TODO Auto-generated constructor stub
	}
	
	public Auto(String placa, String marca, int modelo, Duenio duenio) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.duenio = duenio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public Duenio getDuenio() {
		return duenio;
	}

	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
