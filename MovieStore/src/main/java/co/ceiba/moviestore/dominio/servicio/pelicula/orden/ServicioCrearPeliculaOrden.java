package co.ceiba.moviestore.dominio.servicio.pelicula.orden;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPeliculaOrden;

public class ServicioCrearPeliculaOrden {

	private final RepositorioPeliculaOrden repositorioPeliculaOrden;
	
	private final RepositorioPelicula repositorioPelicula;
	
	private final RepositorioOrden repositorioOrden;

	
	
	public ServicioCrearPeliculaOrden(RepositorioPeliculaOrden repositorioPeliculaOrden,
			RepositorioPelicula repositorioPelicula, RepositorioOrden repositorioOrden) {
		this.repositorioPeliculaOrden = repositorioPeliculaOrden;
		this.repositorioPelicula = repositorioPelicula;
		this.repositorioOrden = repositorioOrden;
	}



	public void crear(PeliculaOrden peliculaOrden) {
		ComandoOrden orden= buscarOrden(peliculaOrden.getOrden().getNumeroOrden());
		ComandoPelicula pelicula= buscarPelicula(peliculaOrden.getPelicula().getNombre());
		if(orden == null || pelicula==null) {
			throw new ExcepcionGenerica("No existe los elementos a asociar");
		}
		this.repositorioPeliculaOrden.crear(pelicula.getIdProducto(),orden.getNumeroOrden());
	}
	
	private ComandoPelicula buscarPelicula(String nombre) {
		return this.repositorioPelicula.buscar(nombre);
	}
	
	private  ComandoOrden buscarOrden(int numero) {
		return this.repositorioOrden.buscar(numero);
	}
	
	
	
	
	
}
