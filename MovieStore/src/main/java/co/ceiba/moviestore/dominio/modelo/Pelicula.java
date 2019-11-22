package co.ceiba.moviestore.dominio.modelo;

public class Pelicula {

	private int idProducto;
	
	private String nombre;
	
	private double valor;

	public Pelicula(int idProducto, String nombre, double valor) {
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
