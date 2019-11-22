package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;

/**
 * Interface repositorio categoria
 * @author david.sanchez
 *
 */
public interface RepositorioCategoria {

	/**
	 * permite crear categoria 
	 * @param categoria nueva categoria 
	 */
	void crear(Categoria categoria);
	
	/**
	 * Permite vvalidar la existencia de una categoria 
	 * @param categoria categoriaExistente
	 */
	boolean existe(Categoria categoria);
	
	/**
	 * Permite eliminar una categoria del sistema
	 * @param categoria categoria
	 */
	void eliminar(String nombre);
	
	/**
	 * Permite listar todas las categorias del sistema
	 * @return lista de categoria 
	 */
	List<ComandoCategoria> listar();
	
	/**
	 * Permite buscar una categoria por nombre 
	 * @param nombre de la categoria 
	 * @return categoria
	 */
	ComandoCategoria buscar(String nombre);
	
	

}
