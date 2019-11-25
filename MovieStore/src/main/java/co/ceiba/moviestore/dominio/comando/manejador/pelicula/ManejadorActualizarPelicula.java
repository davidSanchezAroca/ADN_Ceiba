package co.ceiba.moviestore.dominio.comando.manejador.pelicula;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaPelicula;
import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioActualizarPelicula;

@Component
public class ManejadorActualizarPelicula {

	private FabricaPelicula fabricaPelicula;
	
	private ServicioActualizarPelicula servicioActualizarPelicula;

	public ManejadorActualizarPelicula(FabricaPelicula fabricaPelicula,
			ServicioActualizarPelicula servicioActualizarPelicula) {
		this.fabricaPelicula = fabricaPelicula;
		this.servicioActualizarPelicula = servicioActualizarPelicula;
	}
	
	public void actualizar(ComandoPelicula comandoPelicula) {
		Pelicula pelicula= fabricaPelicula.crear(comandoPelicula);
		this.servicioActualizarPelicula.actualizar(pelicula);
	}
	
	
}
