package co.ceiba.moviestore.dominio.servicio.pelicula;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;

public class ServicioListarPelicula {

	private final RepositorioPelicula repositorioPelicula;

	public ServicioListarPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public List<ComandoPelicula> listar(){
		return this.repositorioPelicula.listar();
	}
	
	
}
