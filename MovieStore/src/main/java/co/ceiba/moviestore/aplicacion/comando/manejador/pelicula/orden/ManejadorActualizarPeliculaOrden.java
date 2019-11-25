package co.ceiba.moviestore.aplicacion.comando.manejador.pelicula.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaPeliculaOrden;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;
import co.ceiba.moviestore.dominio.servicio.pelicula.orden.ServicioActualizarPeliculaOrden;

@Component
public class ManejadorActualizarPeliculaOrden {

	private final FabricaPeliculaOrden fabricaPeliculaOrden;
	
	private final ServicioActualizarPeliculaOrden servicioActualizarPeliculaOrden;

	public ManejadorActualizarPeliculaOrden(FabricaPeliculaOrden fabricaPeliculaOrden,
			ServicioActualizarPeliculaOrden servicioActualizarPeliculaOrden) {
		this.fabricaPeliculaOrden = fabricaPeliculaOrden;
		this.servicioActualizarPeliculaOrden = servicioActualizarPeliculaOrden;
	}
	
	public void actualizar(ComandoPeliculaOrden comandoPeliculaOrden) {
		PeliculaOrden peliculaOrden = fabricaPeliculaOrden.crear(comandoPeliculaOrden);
		this.servicioActualizarPeliculaOrden.actualizar(peliculaOrden);
	}
}
