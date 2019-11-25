package co.ceiba.moviestore.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula.ManejadorAsociarCategoriaPelicula;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula.ManejadorEliminarCategoriaPelicula;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula.ManejadorListarCategoriaPelicula;

@RestController
@RequestMapping(value = "/categoria/pelicula")
public class CategoriaPeliculaControlador {

	private final ManejadorAsociarCategoriaPelicula manejadorAsociarCategoriaPelicula;
	
	private final ManejadorEliminarCategoriaPelicula manejadorEliminarCategoriaPelicula;
	
	private final ManejadorListarCategoriaPelicula manejadorListarCategoriaPelicula;

	public CategoriaPeliculaControlador(ManejadorAsociarCategoriaPelicula manejadorAsociarCategoriaPelicula, 
			ManejadorEliminarCategoriaPelicula manejadorEliminarCategoriaPelicula,
			ManejadorListarCategoriaPelicula manejadorListarCategoriaPelicula) {
		this.manejadorAsociarCategoriaPelicula = manejadorAsociarCategoriaPelicula;
		this.manejadorEliminarCategoriaPelicula = manejadorEliminarCategoriaPelicula;
		this.manejadorListarCategoriaPelicula = manejadorListarCategoriaPelicula;
	}
	
	@PostMapping(path = "/asociar")
	public void asociar(@RequestBody ComandoCategoriaPelicula comandoCategoriaPelicula) {
		this.manejadorAsociarCategoriaPelicula.asociar(comandoCategoriaPelicula);
	}
	
	
	@DeleteMapping(path = "/eliminar")
	public void eliminar(@RequestBody ComandoCategoriaPelicula comandoCategoriaPelicula) {
		this.manejadorEliminarCategoriaPelicula.eliminar(comandoCategoriaPelicula);
	}
	
	@GetMapping(path = "/listar")
	@ResponseBody
	public List<ComandoCategoriaPelicula> listar(){
		return this.manejadorListarCategoriaPelicula.listar();
	}
}
