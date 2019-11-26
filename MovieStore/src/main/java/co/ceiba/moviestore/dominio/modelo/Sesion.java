package co.ceiba.moviestore.dominio.modelo;

import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class Sesion {

	public  static final String DATOS_INCOMPLETOS_SESION= "La informacion se encuentra incompleta";
	private String usuario;
	
	private String password;
	
	private Cliente cliente;

	public Sesion(String usuario, String password, Cliente cliente) {
		ValidadorArgumento.validarObligatorio(usuario, DATOS_INCOMPLETOS_SESION);
		ValidadorArgumento.validarObligatorio(password, DATOS_INCOMPLETOS_SESION);
		ValidadorArgumento.validarObligatorio(cliente.getCedula(),DATOS_INCOMPLETOS_SESION);
		this.usuario = usuario;
		this.password = password;
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
}
