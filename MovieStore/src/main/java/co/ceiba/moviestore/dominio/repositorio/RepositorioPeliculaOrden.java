package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;

public interface RepositorioPeliculaOrden {

	void crear(int idPelicula, int idOrden);
	
	void actualizar(int idPelicula, int idOrden);
	
	List<ComandoPeliculaOrden> comandoPeliculaOrden();
	
}
