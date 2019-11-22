package co.ceiba.moviestore.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.comando.manejador.pelicula.ManejadorActualizarPelicula;
import co.ceiba.moviestore.dominio.comando.manejador.pelicula.ManejadorCrearPelicula;
import co.ceiba.moviestore.dominio.comando.manejador.pelicula.ManejadorEliminarPelicula;
import co.ceiba.moviestore.dominio.comando.manejador.pelicula.ManejadorListarPeliculas;

@RestController
@RequestMapping(value = "/pelicula")
public class PeliculaControlador {

	private final ManejadorCrearPelicula manejadorCrearPelicula;
	private final ManejadorEliminarPelicula manejadorEliminarPelicula;
	private final ManejadorListarPeliculas manejadorListarPeliculas;
	private final ManejadorActualizarPelicula manejadorActualizarPelicula;

	public PeliculaControlador(ManejadorCrearPelicula manejadorCrearPelicula,
							   ManejadorEliminarPelicula manejadorEliminarPelicula,
							   ManejadorListarPeliculas manejadorListarPeliculas,
							   ManejadorActualizarPelicula manejadorActualizarPelicula) {
		this.manejadorCrearPelicula = manejadorCrearPelicula;
		this.manejadorEliminarPelicula=manejadorEliminarPelicula;
		this.manejadorListarPeliculas=manejadorListarPeliculas;
		this.manejadorActualizarPelicula=manejadorActualizarPelicula;
	}
	
	
	@PostMapping(value = "/agregar")
	public void crear(@RequestBody ComandoPelicula comandoPelicula) {
		System.out.println(comandoPelicula.getNombre()+ "---"+comandoPelicula.getValor());
		this.manejadorCrearPelicula.crear(comandoPelicula);
	}
	
	@DeleteMapping(value = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre) {
		this.manejadorEliminarPelicula.eliminar(nombre);
	}
	
	@PostMapping(value = "/actualizar")
	public void actualizar(@RequestBody ComandoPelicula comandoPelicula) {
		this.manejadorActualizarPelicula.actualizar(comandoPelicula);
	}
	
	@GetMapping(value = "/listar")
	@ResponseBody
	public List<ComandoPelicula> listar() {
		return manejadorListarPeliculas.listar();
	}
	
	
}
