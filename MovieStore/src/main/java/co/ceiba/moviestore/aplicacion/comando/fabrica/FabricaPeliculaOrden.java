package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;

@Component
public class FabricaPeliculaOrden {

	public PeliculaOrden crear(ComandoPeliculaOrden comandoPeliculaOrden) {
		return new PeliculaOrden(comandoPeliculaOrden.getPelicula(), comandoPeliculaOrden.getOrden());
	}
}
