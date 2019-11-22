package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;

/**
 * Repositorio categoria pelicula 
 * @author david.sanchez
 *
 */
public interface RepositorioCategoriaPelicula {

	/**
	 * Metodo que permite asociar una categoria a una pelicula 
	 * @param categoriaPelicula
	 */
	void asociar(CategoriaPelicula categoriaPelicula);
	
	/**
	 * Pemite eliminar una categoria de una pelicula
	 * @param categoriaPelicula
	 */
	void eliminar(int categoria, int pelicula);
	
	/**
	 * Permite listar las peliculas y sus categorias 
	 * @param categoriaPelicula
	 * @return
	 */
	List<ComandoCategoriaPelicula> listar();
}
