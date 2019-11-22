package co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCategoriaPelicula;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioEliminarCategoriaPelicula;

@Component
public class ManejadorEliminarCategoriaPelicula {

	private final ServicioEliminarCategoriaPelicula servicioEliminarCategoriaPelicula;
	
	private final FabricaCategoriaPelicula fabricaCategoriaPelicula;

	public ManejadorEliminarCategoriaPelicula(ServicioEliminarCategoriaPelicula servicioEliminarCategoriaPelicula,
			FabricaCategoriaPelicula fabricaCategoriaPelicula) {
		this.servicioEliminarCategoriaPelicula = servicioEliminarCategoriaPelicula;
		this.fabricaCategoriaPelicula = fabricaCategoriaPelicula;
	}
	
	
	public void eliminar(ComandoCategoriaPelicula comandoCategoriaPelicula) {
		CategoriaPelicula categoriaPelicula = this.fabricaCategoriaPelicula.crear(comandoCategoriaPelicula);
		this.servicioEliminarCategoriaPelicula.eliminar(categoriaPelicula);
	}
	
	
}
