package co.ceiba.moviestore.dominio.comando.manejador.pelicula;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioEliminarPelicula;

@Component
public class ManejadorEliminarPelicula {

	private final ServicioEliminarPelicula servicioEliminarpelicula;

	public ManejadorEliminarPelicula(ServicioEliminarPelicula servicioEliminarpelicula) {
		this.servicioEliminarpelicula = servicioEliminarpelicula;
	}
	
	public void eliminar(String nombre) {
		servicioEliminarpelicula.eliminar(nombre);
	}
	
}
