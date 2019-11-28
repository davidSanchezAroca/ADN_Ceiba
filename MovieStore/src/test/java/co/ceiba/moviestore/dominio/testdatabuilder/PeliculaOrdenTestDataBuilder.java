package co.ceiba.moviestore.dominio.testdatabuilder;

import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;

public class PeliculaOrdenTestDataBuilder {

	private Pelicula pelicula;
	
	private Orden orden;
	
	public PeliculaOrdenTestDataBuilder() {
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
	
	public PeliculaOrden build() {
		return new PeliculaOrden(pelicula, orden);
	}
}
