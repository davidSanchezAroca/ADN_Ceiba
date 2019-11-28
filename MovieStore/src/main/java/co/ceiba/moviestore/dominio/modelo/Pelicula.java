package co.ceiba.moviestore.dominio.modelo;

import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class Pelicula {

	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre es un dato obligatorio.";
	
	private static final String EL_VALOR_ES_UN_DATO_OBLIGATORIO = "El valor es un dato obligatorio";
	
	private int idProducto;
	
	private String nombre;
	
	private double valor;

	public Pelicula(int idProducto, String nombre, double valor) {
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarNumero(valor, EL_VALOR_ES_UN_DATO_OBLIGATORIO);
		this.nombre = nombre;
		this.valor = valor;
		this.idProducto = idProducto;
	}
	
	public Pelicula() {}

	/**
	 * @return Metodo que obtiene el valor de la variable idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}


	/**
	 * @param idProducto Variable que modifica a  idProducto 
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	/**
	 * @return Metodo que obtiene el valor de la variable nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre variable que modifica el valor  nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor variable que modifica el valor  valor 
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	
}
