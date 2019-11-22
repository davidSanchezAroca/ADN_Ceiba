package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;

@Component
public class FabricaCategoriaPelicula {

	public CategoriaPelicula crear(ComandoCategoriaPelicula comandoCategoriaPelicula) {
		return new CategoriaPelicula(comandoCategoriaPelicula.getPelicula(),comandoCategoriaPelicula.getCategoria());
	}
}
