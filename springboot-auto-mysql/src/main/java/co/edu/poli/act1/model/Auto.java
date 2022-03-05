package co.edu.poli.act1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vehiculos")
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String placa;
	private String marca;
	private int modelo;
	private String color;
	
	@OneToOne(mappedBy = "auto", cascade = CascadeType.ALL)
	@JsonIgnore
	private TarjetaProp tarjetaProp;
	
	public Auto() {
	}
	
	public Auto(int id, String placa, String marca, int modelo, String color) {
		super();
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public TarjetaProp getTarjetaProp() {
		return tarjetaProp;
	}

	public void setTarjetaProp(TarjetaProp tarjetaProp) {
		this.tarjetaProp = tarjetaProp;
	}
	
}
