package co.ceiba.moviestore.dominio.servicio.pelicula;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;

public class ServicioActualizarPelicula {

	private final RepositorioPelicula repositorioPelicula;

	public ServicioActualizarPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public void actualizar(Pelicula pelicula) {
		ComandoPelicula peliculaBuscar= buscar(pelicula.getNombre());
		if(peliculaBuscar != null) {
			pelicula.setIdProducto(peliculaBuscar.getIdProducto());
			this.repositorioPelicula.actualizar(pelicula);
		}
		
	}
	
	public ComandoPelicula buscar(String nombre) {
		return this.repositorioPelicula.buscar(nombre);
	}
	
	
}
