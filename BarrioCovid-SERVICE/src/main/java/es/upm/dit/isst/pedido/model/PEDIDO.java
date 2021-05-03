package es.upm.dit.isst.pedido.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PEDIDO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String comprador;
	private String vendedor;
	private String voluntario;
	private int	id_pedido;
	private String status;
	
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getVoluntario() {
		return voluntario;
	}
	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
