package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.manejador.ManejadorCrearCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControlador {
	
	private final ManejadorCrearCategoria manejadorCrearCategoria;

	public CategoriaControlador(ManejadorCrearCategoria manejadorCrearCategoria) {
		super();
		this.manejadorCrearCategoria = manejadorCrearCategoria;
	}
	
	@PostMapping(path ="/agregarCategoria")
	public void agregarCategoria(@RequestBody ComandoCategoria comandoCategoria) {
		this.manejadorCrearCategoria.crear(comandoCategoria);
	}

}
