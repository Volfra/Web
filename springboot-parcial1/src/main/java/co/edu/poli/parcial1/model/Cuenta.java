package co.edu.poli.parcial1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")
public class Cuenta {
	
	@Id
	@Column(name="Numero")
	private String numero;
	
	@Column(name="IdCliente")
	private String idCliente;
	
	@Column(name="TipoCuenta")
	private int tipoCuenta;
	
	@OneToMany(mappedBy = "cuenta",cascade = CascadeType.ALL)
    private Set<Transaccion> transacciones;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}	

	public Set<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Set<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
}
