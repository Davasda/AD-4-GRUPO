package com.edix.restventas.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double total;

	//uni-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//uni-directional many-to-one association to Comercial
	@ManyToOne
	@JoinColumn(name="id_comercial")
	private Comercial comerciale;

	public Pedido() {
	}
	
	

	public Pedido(int idPedido, Date fecha, double total, Cliente cliente, Comercial comerciale) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.comerciale = comerciale;
	}



	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comercial getComerciale() {
		return this.comerciale;
	}

	public void setComerciale(Comercial comerciale) {
		this.comerciale = comerciale;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", total=" + total + ", cliente=" + cliente
				+ ", comerciale=" + comerciale + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && idPedido == other.idPedido;
	}
	
	

}