package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.comando.manejador.pelicula.ManejadorCrearPelicula;

@RestController
@RequestMapping(value = "/pelicula")
public class PeliculaControlador {

	private final ManejadorCrearPelicula manejadorCrearPelicula;

	public PeliculaControlador(ManejadorCrearPelicula manejadorCrearPelicula) {
		this.manejadorCrearPelicula = manejadorCrearPelicula;
	}
	
	
	@PostMapping(value = "/agregar")
	public void crear(@RequestBody ComandoPelicula comandoPelicula) {
		System.out.println(comandoPelicula.getNombre()+ "---"+comandoPelicula.getValor());
		this.manejadorCrearPelicula.crear(comandoPelicula);
	}
	
	@DeleteMapping(value = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre) {
		
	}
	
	
}
