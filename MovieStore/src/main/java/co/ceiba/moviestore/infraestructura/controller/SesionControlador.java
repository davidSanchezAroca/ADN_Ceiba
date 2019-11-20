package co.ceiba.moviestore.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.moviestore.aplicacion.comando.ComandoSesion;
import co.ceiba.moviestore.aplicacion.comando.manejador.sesion.ManejadorActualizarSesion;
import co.ceiba.moviestore.aplicacion.comando.manejador.sesion.ManejadorCrearSesion;

@RestController
@RequestMapping(value = "/sesion")
public class SesionControlador {

	private final ManejadorCrearSesion manejadorCrearSesion;
	private final ManejadorActualizarSesion manejadorAcualizarSecion;
	
	
	public SesionControlador(ManejadorCrearSesion manejadorCrearSesion,
			ManejadorActualizarSesion manejadorAcualizarSecion) {
		this.manejadorCrearSesion = manejadorCrearSesion;
		this.manejadorAcualizarSecion = manejadorAcualizarSecion;
	}
	
	@PostMapping(path = "/crear")
	public void crear(@RequestBody ComandoSesion comandoSesion) {
		this.manejadorCrearSesion.crear(comandoSesion);
	}
	
	@PostMapping(path = "/actualizar")
	public void actualizar(@RequestBody ComandoSesion comandoSesion) {
		this.manejadorAcualizarSecion.actualizar(comandoSesion);
	}
	
	
}
