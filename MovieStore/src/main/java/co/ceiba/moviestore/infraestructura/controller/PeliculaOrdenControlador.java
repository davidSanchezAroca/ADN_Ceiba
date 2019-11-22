package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.pelicula.orden.ManejadorCrearPeliculaOrden;

@RestController
@RequestMapping(value = "/pelicula/orden")
public class PeliculaOrdenControlador {

	private final ManejadorCrearPeliculaOrden manejadorCrearPeliculaOrden;

	public PeliculaOrdenControlador(ManejadorCrearPeliculaOrden manejadorCrearPeliculaOrden) {
		this.manejadorCrearPeliculaOrden = manejadorCrearPeliculaOrden;
	}
	
	
	@PostMapping("/agregar")
	public void crear(@RequestBody ComandoPeliculaOrden comandoPeliculaOrden) {
		this.manejadorCrearPeliculaOrden.crear(comandoPeliculaOrden);
	}
	
	
}
