package co.ceiba.moviestore.aplicacion.comando.manejador.pelicula.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaPeliculaOrden;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;
import co.ceiba.moviestore.dominio.servicio.pelicula.orden.ServicioCrearPeliculaOrden;

@Component
public class ManejadorCrearPeliculaOrden {

	private final FabricaPeliculaOrden fabricaPeliculaOrden;
	
	private final ServicioCrearPeliculaOrden servicioCrearPeliculaOrden;

	public ManejadorCrearPeliculaOrden(FabricaPeliculaOrden fabricaPeliculaOrden,
			ServicioCrearPeliculaOrden servicioCrearPeliculaOrden) {
		this.fabricaPeliculaOrden = fabricaPeliculaOrden;
		this.servicioCrearPeliculaOrden = servicioCrearPeliculaOrden;
	}
	
	public void crear(ComandoPeliculaOrden comandoPeliculaOrden) {
		PeliculaOrden peliculaOrden = this.fabricaPeliculaOrden.crear(comandoPeliculaOrden);
		this.servicioCrearPeliculaOrden.crear(peliculaOrden);
	}
	
	
}
