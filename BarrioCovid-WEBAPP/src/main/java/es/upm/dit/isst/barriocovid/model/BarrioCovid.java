package es.upm.dit.isst.barriocovid.model;

import java.io.Serializable;




public class BarrioCovid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	private String email;
	private String password;
	
	private int status;
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

	private String rol;
	
	//
	
	
	private byte[] productos;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarrioCovid other = (BarrioCovid) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	

}