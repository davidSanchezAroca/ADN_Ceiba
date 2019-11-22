package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

public interface RepositorioPelicula {

	void crear(Pelicula pelicula);
	
	void eliminar(String nombre);
	
	List<ComandoPelicula> listar();
	
	void actualizar(Pelicula pelicula);
	
	ComandoPelicula buscar(String nombre);
}
