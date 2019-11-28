package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

public class ComandoPeliculaOrdenTestDataBuilder {

	private Pelicula pelicula;
	
	private Orden orden;

	public ComandoPeliculaOrdenTestDataBuilder() {
		this.pelicula = new Pelicula();
		pelicula.setNombre("terror");
		this.orden = new Orden();
		orden.setNumeroOrden(1);
	}

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
	
	public ComandoPeliculaOrden build() {
		return new ComandoPeliculaOrden(pelicula, orden);
	}
}
