package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Cliente;

public class ComandoSesion {
	
	private String usuario;
	
	private String password;
	
	private Cliente cliente;

	public ComandoSesion(String usuario, String password, Cliente cliente) {
		this.usuario = usuario;
		this.password = password;
		this.cliente = cliente;
	}

	public ComandoSesion() {
	}

	  
	/**
	 * @return Metodo que obtiene el valor de la variable cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente variable que modifica el valor  cliente 
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario variable que modifica el valor  usuario 
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password variable que modifica el valor  password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
