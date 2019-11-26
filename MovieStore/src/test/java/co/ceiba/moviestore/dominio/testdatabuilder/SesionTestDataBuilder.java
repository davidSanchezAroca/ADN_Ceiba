package co.ceiba.moviestore.dominio.testdatabuilder;

import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.modelo.Sesion;

public class SesionTestDataBuilder {
	
	private String usuario;
	
	private String password;
	
	private Cliente cliente;
	
	public SesionTestDataBuilder() {
		usuario = "juanda";
		password = "admin";
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
	
	public Sesion build() {
		return new Sesion(usuario, password, cliente);
	}
}
