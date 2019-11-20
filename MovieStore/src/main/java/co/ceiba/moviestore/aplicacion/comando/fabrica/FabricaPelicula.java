package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.modelo.Pelicula;

@Component
public class FabricaPelicula {
	
	public Pelicula crear(ComandoPelicula comandoPelicula) {
		return new Pelicula(comandoPelicula.getNombre(), comandoPelicula.getValor());
	}

}
