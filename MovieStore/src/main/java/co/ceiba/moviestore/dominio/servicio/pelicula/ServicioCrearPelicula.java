package co.ceiba.moviestore.dominio.servicio.pelicula;

import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;

public class ServicioCrearPelicula {
	
	private final RepositorioPelicula repositorioPelicula;
	
	public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}

	public void crear(Pelicula pelicula) {
		repositorioPelicula.crear(pelicula);
	}
}
