package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.pelicula.orden.ManejadorActualizarPeliculaOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.pelicula.orden.ManejadorCrearPeliculaOrden;

@RestController
@RequestMapping(value = "/pelicula/orden")
public class PeliculaOrdenControlador {

	private final ManejadorCrearPeliculaOrden manejadorCrearPeliculaOrden;
	private final ManejadorActualizarPeliculaOrden manejadorActualizarPeliculaOrden;

	public PeliculaOrdenControlador(ManejadorCrearPeliculaOrden manejadorCrearPeliculaOrden,
									ManejadorActualizarPeliculaOrden manejadorActualizarPeliculaOrden) {
		this.manejadorCrearPeliculaOrden = manejadorCrearPeliculaOrden;
		this.manejadorActualizarPeliculaOrden = manejadorActualizarPeliculaOrden;
	}
	
	
	@PostMapping("/agregar")
	public void crear(@RequestBody ComandoPeliculaOrden comandoPeliculaOrden) {
		this.manejadorCrearPeliculaOrden.crear(comandoPeliculaOrden);
	}
	
	@DeleteMapping("/actualizar")
	public void actualizar(ComandoPeliculaOrden comandoPeliculaOrden) {
		this.manejadorActualizarPeliculaOrden.actualizar(comandoPeliculaOrden);
	}
	
	
}
