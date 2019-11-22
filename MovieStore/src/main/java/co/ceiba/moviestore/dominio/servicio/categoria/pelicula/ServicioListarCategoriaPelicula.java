package co.ceiba.moviestore.dominio.servicio.categoria.pelicula;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoriaPelicula;

public class ServicioListarCategoriaPelicula {

	private final RepositorioCategoriaPelicula repositorioCategoriaPelicula;

	public ServicioListarCategoriaPelicula(RepositorioCategoriaPelicula repositorioCategoriaPelicula) {
		this.repositorioCategoriaPelicula = repositorioCategoriaPelicula;
	}
	
	public List<ComandoCategoriaPelicula> listar(){
		return this.repositorioCategoriaPelicula.listar();
	}
	
	
}
