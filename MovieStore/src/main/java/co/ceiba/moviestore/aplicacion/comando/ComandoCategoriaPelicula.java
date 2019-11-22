package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

public class ComandoCategoriaPelicula {

	private Pelicula pelicula;
	
	private Categoria categoria;

	public ComandoCategoriaPelicula(Pelicula pelicula, Categoria categoria) {
		this.pelicula = pelicula;
		this.categoria = categoria;
	}

	public ComandoCategoriaPelicula() {}

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
	 * @return Metodo que obtiene el valor de la variable categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria variable que modifica el valor  categoria 
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
