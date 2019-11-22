package co.ceiba.moviestore.dominio.comando.manejador.pelicula;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaPelicula;
import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioCrearPelicula;

@Component
public class ManejadorCrearPelicula {

	private final FabricaPelicula fabricaPelicula;
	
	private final ServicioCrearPelicula servicioCrearPelicula;

	public ManejadorCrearPelicula(FabricaPelicula fabricaPelicula, ServicioCrearPelicula servicioCrearPelicula) {
		this.fabricaPelicula = fabricaPelicula;
		this.servicioCrearPelicula = servicioCrearPelicula;
	}
	
	public void crear(ComandoPelicula comandoPelicula) {
		Pelicula pelicula= this.fabricaPelicula.crear(comandoPelicula);
		this.servicioCrearPelicula.crear(pelicula);
	}
	
	
}
