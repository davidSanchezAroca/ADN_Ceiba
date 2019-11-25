package co.ceiba.moviestore.dominio.testdatabuilder;

import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;

public class TarjetaTestDataBuilder {

	private String franquicia;
	
	private String numeroCuenta;
	
	private Cliente cliente;
	
	public TarjetaTestDataBuilder() {
		this.franquicia="MasterCard";
		this.numeroCuenta="1234567891234567";
		this.cliente= new Cliente();
		cliente.setCedula("123");
	}

	/**
	 * @return Metodo que obtiene el valor de la variable franquicia
	 */
	public String getFranquicia() {
		return franquicia;
	}

	/**
	 * @param franquicia variable que modifica el valor  franquicia 
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
	
	public Tarjeta build() {
		return new Tarjeta(franquicia, numeroCuenta, cliente);
	}
}
