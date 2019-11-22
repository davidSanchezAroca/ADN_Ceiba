package co.ceiba.moviestore.dominio.servicio.categoria.pelicula;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;

public class ServicioEliminarCategoriaPelicula {

	private final RepositorioCategoriaPelicula repositorioCategoriaPelicula;
	private final RepositorioCategoria repositorioCategoria;
	private final RepositorioPelicula repositorioPelicula;

	public ServicioEliminarCategoriaPelicula(RepositorioCategoriaPelicula repositorioCategoriaPelicula,
						RepositorioPelicula repositorioPelicula, RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoriaPelicula = repositorioCategoriaPelicula;
		this.repositorioCategoria=repositorioCategoria;
		this.repositorioPelicula=repositorioPelicula;
	}
	
	public void eliminar(CategoriaPelicula categoriaPelicula) {
		ComandoCategoria categoria=buscarCategoria(categoriaPelicula.getCategoria().getNombre());
		ComandoPelicula pelicula= buscarPelicula(categoriaPelicula.getPelicula().getNombre());
		if(categoria== null || pelicula == null) {
			throw new ExcepcionGenerica("No se puede asociar la categoria y pelicula");
		}
		this.repositorioCategoriaPelicula.eliminar(categoria.getIdCategoria(), pelicula.getIdProducto());		
	}
	
	private ComandoPelicula buscarPelicula(String nombre) {
		return this.repositorioPelicula.buscar(nombre);
	}
	
	private ComandoCategoria buscarCategoria(String nombre) {
		return  this.repositorioCategoria.buscar(nombre);
	}
	
	
	
}
