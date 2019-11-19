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
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.manejador.ManejadorCategoria;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControlador {
	
	private final ManejadorCategoria manejadorCategoria;

	public CategoriaControlador(ManejadorCategoria manejadorCrearCategoria) {
		
		this.manejadorCategoria = manejadorCrearCategoria;
	}
	
	@PostMapping(path ="/agregar")
	public void agregar(@RequestBody ComandoCategoria comandoCategoria) {
		this.manejadorCategoria.crear(comandoCategoria);
	}
	
	@DeleteMapping(path = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre) {
		this.manejadorCategoria.eliminar(nombre);
	} 
	
	@GetMapping(path = "/listar")
	@ResponseBody
	public List<ComandoCategoria> listar() {
		return this.manejadorCategoria.listar();
	}
	
	

}
