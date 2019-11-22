package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;

public interface RepositorioPeliculaOrden {

	void crear(int idPelicula, int idOrden);
	
	void actualizar(PeliculaOrden comandoPeliculaOrden);
	
	List<ComandoPeliculaOrden> comandoPeliculaOrden();
	
}
