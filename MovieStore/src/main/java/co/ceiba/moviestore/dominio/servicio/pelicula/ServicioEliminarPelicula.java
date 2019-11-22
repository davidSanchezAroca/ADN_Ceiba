package co.ceiba.moviestore.dominio.servicio.pelicula;

import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;

public class ServicioEliminarPelicula {

	private final RepositorioPelicula repositorioPelicula;
	
	public ServicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}

	public void eliminar(String nombre) {
		this.repositorioPelicula.eliminar(nombre);
	}
}
