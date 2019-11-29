package co.ceiba.moviestore.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.orden.ManejadorActualizarOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.orden.ManejadorBuscarOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.orden.ManejadorCrearOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.orden.ManejadorListarOrden;
import co.ceiba.moviestore.aplicacion.comando.manejador.orden.ManejadorPrecioOrden;

@RestController
@RequestMapping(value = "/orden")
public class OrdenControlador {

	private final ManejadorCrearOrden manejadorCrearOrden;
	private final ManejadorListarOrden manejadorListarOrden;
	private final ManejadorActualizarOrden manejadorActualizarOrden;
	private final ManejadorBuscarOrden manejadorBuscarOrden;
	private final ManejadorPrecioOrden manejadorPrecioOrden;

	public OrdenControlador(ManejadorCrearOrden manejadorCrearOrden,
							ManejadorListarOrden manejadorListarOrden,
							ManejadorActualizarOrden manejadorActualizarOrden,
							ManejadorBuscarOrden manejadorBuscarOrden,
							ManejadorPrecioOrden manejadorPrecioOrden) {
		this.manejadorCrearOrden = manejadorCrearOrden;
		this.manejadorListarOrden = manejadorListarOrden;
		this.manejadorActualizarOrden = manejadorActualizarOrden;
		this.manejadorBuscarOrden = manejadorBuscarOrden;
		this.manejadorPrecioOrden = manejadorPrecioOrden;
	}
	
	@PostMapping(path = "/agregar")
	public void crear(@RequestBody ComandoOrden comandoOrden) {
		this.manejadorCrearOrden.crear(comandoOrden);
	}
	
	@GetMapping(path = "/listar/{cedula}")
	public List<ComandoOrden> lista(@PathVariable String cedula){
		return  this.manejadorListarOrden.listar(cedula);
	}
	
	@PostMapping(path = "/actualizar")
	public void actualizar(@RequestBody ComandoOrden comandoOrden) {
	   this.manejadorActualizarOrden.actualizar(comandoOrden);
	}
	
	@PostMapping(path = "/buscar")
	public ComandoOrden buscar(@RequestBody ComandoOrden comandoOrden) {
		return this.manejadorBuscarOrden.buscar(comandoOrden);
	}
	@PostMapping(path = "/precio")
	public void calcularPrecio(@RequestBody ComandoOrden comandoOrden) {
		this.manejadorPrecioOrden.precio(comandoOrden);
	}
}
