package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioActualizarOrden;

@Component
public class ManejadorActualizarOrden {

	private final FabricaOrden fabricaOrden;
	
	private final ServicioActualizarOrden servicioActualizarOrden;

	public ManejadorActualizarOrden(FabricaOrden fabricaOrden, ServicioActualizarOrden servicioActualizarOrden) {
		this.fabricaOrden = fabricaOrden;
		this.servicioActualizarOrden = servicioActualizarOrden;
	}
	
	public void actualizar(ComandoOrden comandoOrden) {
		Orden orden=fabricaOrden.crear(comandoOrden);
		this.servicioActualizarOrden.actualizar(orden);
	}
	
}
