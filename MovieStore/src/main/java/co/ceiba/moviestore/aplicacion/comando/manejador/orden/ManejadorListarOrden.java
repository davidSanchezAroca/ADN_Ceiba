package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioListarOrden;

@Component
public class ManejadorListarOrden {

	private final ServicioListarOrden servicioListarOrden;

	public ManejadorListarOrden(ServicioListarOrden servicioListarOrden) {
		this.servicioListarOrden = servicioListarOrden;
	}
	
	public List<ComandoOrden> listar(String cedula){
		return this.servicioListarOrden.listar(cedula);
	}
	
}
