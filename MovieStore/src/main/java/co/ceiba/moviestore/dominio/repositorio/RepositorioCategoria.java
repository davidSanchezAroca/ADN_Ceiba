package co.ceiba.moviestore.dominio.repositorio;

import co.ceiba.moviestore.dominio.modelo.Categoria;

public interface RepositorioCategoria {

	/**
	 * permite crear categoria 
	 * @param categoria nueva categoria 
	 */
	void crearCategoria(Categoria categoria);
	
	/**
	 * Permite vvalidar la existencia de una categoria 
	 * @param categoria categoriaExistente
	 */
	boolean existeCategoria(Categoria categoria);
}
