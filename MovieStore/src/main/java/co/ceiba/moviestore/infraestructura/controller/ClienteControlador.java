package co.ceiba.moviestore.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorActualizarCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorBuscarCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorCrearCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorEliminarCliente;
import co.ceiba.moviestore.aplicacion.comando.manejador.cliente.ManejadorListarCliente;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteControlador {

	private final ManejadorCrearCliente manejadorCrearCliente;
	private final ManejadorEliminarCliente manejadorEliminarCliente;
	private final ManejadorActualizarCliente manejadorActualizarCliente;
	private final ManejadorListarCliente manejadorListarCliente;
	private final ManejadorBuscarCliente manejadorBuscarCliente;

	
	
	public ClienteControlador(ManejadorCrearCliente manejadorCrearCliente,
			ManejadorEliminarCliente manejadorEliminarCliente,
			ManejadorActualizarCliente manejadorActualizarCliente,
			ManejadorListarCliente manejadorListarCliente,
			ManejadorBuscarCliente manejadorBuscarCliente) {
		this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorEliminarCliente = manejadorEliminarCliente;
		this.manejadorActualizarCliente= manejadorActualizarCliente;
		this.manejadorListarCliente= manejadorListarCliente;
		this.manejadorBuscarCliente= manejadorBuscarCliente;
	}


	@PostMapping(path = "/agregar")
	public void agregar(@RequestBody ComandoCliente comandoCliente) {
		this.manejadorCrearCliente.crear(comandoCliente);
	}
	
	
	@DeleteMapping(path = "/eliminar/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		this.manejadorEliminarCliente.eliminar(cedula);
	}
	
	
	@PostMapping(path = "/actualizar")
	public void actualizar(@RequestBody ComandoCliente comandoCliente) {
		this.manejadorActualizarCliente.actualizar(comandoCliente);
	}
	
	@GetMapping(path = "/listar")
	@ResponseBody
	public List<ComandoCliente> listar() {
		return this.manejadorListarCliente.listar();
	}
	
	@GetMapping(path = "/buscar/{cedula}")
	public ComandoCliente buscar(@PathVariable("cedula") String cedula) {
		return this.manejadorBuscarCliente.buscar(cedula);
	}
	
}
