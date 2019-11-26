package co.ceiba.moviestore.dominio.modelo;

import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class Tarjeta {

	public  static final String DATOS_INCOMPLETOS_TARJETA= "La informacion se encuentra incompleta";
	public  static final String NUMERO_DIGITOS_TARJETA = "La tarjeta no cuenta con 16 digitos";
	
	private String franquicia;
	
	private String numeroCuenta;
	
	private Cliente cliente;

	public Tarjeta(String franquicia, String numeroCuenta, Cliente cliente) {
		
		ValidadorArgumento.validarObligatorio(numeroCuenta,DATOS_INCOMPLETOS_TARJETA);
		ValidadorArgumento.validarObligatorio(franquicia,DATOS_INCOMPLETOS_TARJETA);
		ValidadorArgumento.validarObligatorio(cliente.getCedula(),DATOS_INCOMPLETOS_TARJETA);
		ValidadorArgumento.validarLongitud(numeroCuenta, 16, NUMERO_DIGITOS_TARJETA);
		this.franquicia = franquicia;
		this.numeroCuenta = numeroCuenta;
		this.cliente = cliente;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable franquicia
	 */
	public String getFranquicia() {
		return franquicia;
	}

	/**
	 * @param franquicia Variable que modifica a  franquicia 
	 */
	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	

	/**
	 * @return Metodo que obtiene el valor de la variable numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta variable que modifica el valor  numeroCuenta 
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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
