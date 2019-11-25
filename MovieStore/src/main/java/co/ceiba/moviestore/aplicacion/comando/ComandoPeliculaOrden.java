package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

public class ComandoPeliculaOrden {

	private Pelicula pelicula;
	
	private Orden orden;

	public ComandoPeliculaOrden(Pelicula pelicula, Orden orden) {
		this.pelicula = pelicula;
		this.orden = orden;
	}
	
	public ComandoPeliculaOrden() {}

	/**
	 * @return Metodo que obtiene el valor de la variable pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula variable que modifica el valor  pelicula 
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable orden
	 */
	public Orden getOrden() {
		return orden;
	}

	/**
	 * @param orden variable que modifica el valor  orden 
	 */
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
}
