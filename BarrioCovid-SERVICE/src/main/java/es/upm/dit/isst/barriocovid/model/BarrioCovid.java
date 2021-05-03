package es.upm.dit.isst.barriocovid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

//Modelo  de BarrioCovid-SERVICE
@Entity
public class BarrioCovid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String password;
	private String rol;
	//variables a la base de datos
	private String Vendedor; //advisor del TFG
	private String Voluntario;
	private int status;
	
	@Lob
	private byte[] productos;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public byte[] getProductos() {
		return productos;
	}

	public void setProductos(byte[] productos) {
		this.productos = productos;
	}

	public String getVendedor() {
		return Vendedor;
	}

	public void setVendedor(String vendedor) {
		Vendedor = vendedor;
	}

	public String getVoluntario() {
		return Voluntario;
	}

	public void setVoluntario(String voluntario) {
		Voluntario = voluntario;
	}



}
