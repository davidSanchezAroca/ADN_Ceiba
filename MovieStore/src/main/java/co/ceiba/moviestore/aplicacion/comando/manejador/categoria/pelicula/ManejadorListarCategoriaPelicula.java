package co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula;

import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioListarCategoriaPelicula;

@Component
public class ManejadorListarCategoriaPelicula {

	private final ServicioListarCategoriaPelicula servicioListarCategoriaPelicula;

	public ManejadorListarCategoriaPelicula(ServicioListarCategoriaPelicula servicioListarCategoriaPelicula) {
		this.servicioListarCategoriaPelicula = servicioListarCategoriaPelicula;
	}
	
	public List<ComandoCategoriaPelicula> listar(){
		return this.servicioListarCategoriaPelicula.listar();
	}
	
}
