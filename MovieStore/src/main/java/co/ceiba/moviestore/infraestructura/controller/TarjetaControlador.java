package co.ceiba.moviestore.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta.ManejadorBuscarTarjeta;
import co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta.ManejadorCrearTarjeta;
import co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta.ManejadorEliminarTarjeta;
import co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta.ManejadorListarTarjeta;

@RestController
@RequestMapping(value="/tarjeta")
public class TarjetaControlador {

	private final ManejadorCrearTarjeta manejadorCrearTarjeta;
	private final ManejadorEliminarTarjeta manejadorEliminarTarjeta;
	private final ManejadorListarTarjeta manejadorListarTarjeta;
	private final ManejadorBuscarTarjeta manejadorBuscarTarjeta;

	public TarjetaControlador(ManejadorCrearTarjeta manejadorCrearTarjeta,
							ManejadorEliminarTarjeta manejadorEliminarTarjeta,
							ManejadorListarTarjeta manejadorListarTarjeta,
							ManejadorBuscarTarjeta manajeadorBuscarTarjeta) {
		this.manejadorCrearTarjeta = manejadorCrearTarjeta;
		this.manejadorEliminarTarjeta=manejadorEliminarTarjeta;
		this.manejadorListarTarjeta=manejadorListarTarjeta;
		this.manejadorBuscarTarjeta= manajeadorBuscarTarjeta;
	}
	
	@PostMapping(path = "/agregar")
	public void agregar(@RequestBody ComandoTarjeta comandoTarjeta) {
		this.manejadorCrearTarjeta.crear(comandoTarjeta);
	}
	
	@DeleteMapping(path = "/eliminar")
	public void eliminar(@RequestBody ComandoTarjeta comandoTarjeta) {
		this.manejadorEliminarTarjeta.eliminar(comandoTarjeta);
	}
	
	@GetMapping(path = "/listar/{cedula}")
	@ResponseBody
	public List<ComandoTarjeta> listar(@PathVariable String cedula){
		return this.manejadorListarTarjeta.listar(cedula);
	}
	
	@PutMapping(path = "/buscar")
	@ResponseBody
	public ComandoTarjeta buscar(@RequestBody ComandoTarjeta comandoTarjeta) {
		return manejadorBuscarTarjeta.buscar(comandoTarjeta);
	}
}
