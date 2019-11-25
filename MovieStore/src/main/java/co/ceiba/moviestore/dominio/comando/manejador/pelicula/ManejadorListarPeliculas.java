package co.ceiba.moviestore.dominio.comando.manejador.pelicula;

import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioListarPelicula;

@Component
public class ManejadorListarPeliculas {
  
	private ServicioListarPelicula servicioListarPelicula;

	public ManejadorListarPeliculas(ServicioListarPelicula servicioListarPelicula) {
		this.servicioListarPelicula = servicioListarPelicula;
	}
	
	public List<ComandoPelicula> listar(){
		return this.servicioListarPelicula.listar();
	}
	
	
}
