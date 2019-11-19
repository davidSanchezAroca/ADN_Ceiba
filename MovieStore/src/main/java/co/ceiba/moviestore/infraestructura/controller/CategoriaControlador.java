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
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.ManejadorConsultarCategorias;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.ManejadorCrearCategoria;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.ManejadorEliminarCategoria;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControlador {
	
	private final ManejadorCrearCategoria manejadorCrearCategoria;
	private final ManejadorEliminarCategoria manejadorEliminarCategoria;
	private final ManejadorConsultarCategorias manejadorConsultaCategorias;

	
	public CategoriaControlador(ManejadorCrearCategoria manejadorCrearCategoria,
			ManejadorEliminarCategoria manejadorEliminarCategoria,
			ManejadorConsultarCategorias manejadorConsultaCategorias) {
		this.manejadorCrearCategoria = manejadorCrearCategoria;
		this.manejadorEliminarCategoria = manejadorEliminarCategoria;
		this.manejadorConsultaCategorias = manejadorConsultaCategorias;
	}

	@PostMapping(path ="/agregar")
	public void agregar(@RequestBody ComandoCategoria comandoCategoria) {
		this.manejadorCrearCategoria.crear(comandoCategoria);
	}
	
	@DeleteMapping(path = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre) {
		this.manejadorEliminarCategoria.eliminar(nombre);
	} 
	
	@GetMapping(path = "/listar")
	@ResponseBody
	public List<ComandoCategoria> listar() {
		return this.manejadorConsultaCategorias.listar();
	}
	
	

}
