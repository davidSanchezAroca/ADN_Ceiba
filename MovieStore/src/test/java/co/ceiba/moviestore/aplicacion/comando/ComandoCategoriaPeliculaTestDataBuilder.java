package co.ceiba.moviestore.aplicacion.comando;

import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

public class ComandoCategoriaPeliculaTestDataBuilder {

	private Pelicula pelicula;
	
	private Categoria categoria;
	
	public ComandoCategoriaPeliculaTestDataBuilder() {
		pelicula = new Pelicula();
		pelicula.setIdProducto(1);
		pelicula.setNombre("juan");
		categoria = new Categoria();
		categoria.setIdCategoria(1);
		categoria.setNombre("terror");
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
	
	public ComandoCategoriaPelicula build() {
		return new ComandoCategoriaPelicula(pelicula, categoria);
	}
}
