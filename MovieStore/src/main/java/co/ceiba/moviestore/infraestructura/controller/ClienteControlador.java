package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.categoria.ManejadorEliminarCategoria;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorCrearCliente;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteControlador {

	private final ManejadorCrearCliente manejadorCrearCliente;
	private final ManejadorEliminarCategoria manejadorEliminarCliente;

	
	
	public ClienteControlador(ManejadorCrearCliente manejadorCrearCliente,
			ManejadorEliminarCategoria manejadorEliminarCliente) {
		this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorEliminarCliente = manejadorEliminarCliente;
	}


	@PostMapping(path = "/agregar")
	public void agregar(@RequestBody ComandoCliente comandoCliente) {
		this.manejadorCrearCliente.crear(comandoCliente);
	}
	
	
	@DeleteMapping(path = "/eliminar/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		this.manejadorEliminarCliente.eliminar(cedula);
	}
	
	
}
