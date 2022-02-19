package co.edu.poli.act1.model;

public class Auto {
	
	private String placa;
	private String marca;
	private int modelo;
	private String color;
	
	public Auto(String placa, String marca, int modelo, String color) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
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
	
}
