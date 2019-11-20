package co.ceiba.moviestore.dominio.modelo;

public class Tarjeta {

	private String franquicia;
	
	private String numero;
	
	private String cedula;

	public Tarjeta(String franquicia, String numero, String cedula) {
		this.franquicia = franquicia;
		this.numero = numero;
		this.cedula = cedula;
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
	 * @return Metodo que obtiene el valor de la variable numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero Variable que modifica a  numero 
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula Variable que modifica a  cedula 
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
	
}
