package co.ceiba.moviestore.dominio.modelo;

public class Tarjeta {

	private String franquicia;
	
	private String numeroCuenta;
	
	private Cliente cliente;

	public Tarjeta(String franquicia, String numeroCuenta, Cliente cliente) {
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
