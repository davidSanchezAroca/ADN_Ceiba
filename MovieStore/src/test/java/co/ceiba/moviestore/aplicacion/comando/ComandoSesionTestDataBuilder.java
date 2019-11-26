package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Cliente;

public class ComandoSesionTestDataBuilder {
	
	private String usuario;
	
	private String password;
	
	private Cliente cliente;
	
	public ComandoSesionTestDataBuilder() {
		usuario = "juanda";
		password = "a1A@1";
		cliente = new Cliente();
		cliente.setCedula("123");
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
	
	public ComandoSesion build() {
		return new ComandoSesion(usuario, password, cliente);
	}
}
