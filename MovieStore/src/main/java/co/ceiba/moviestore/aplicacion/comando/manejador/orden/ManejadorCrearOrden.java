package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioCrearOrden;

@Component
public class ManejadorCrearOrden {

	private final FabricaOrden fabricaOrden;
	
	private final ServicioCrearOrden servicioCrearOrden;

	public ManejadorCrearOrden(FabricaOrden fabricaOrden, ServicioCrearOrden servicioCrearOrden) {
		this.fabricaOrden = fabricaOrden;
		this.servicioCrearOrden = servicioCrearOrden;
	}
	
	public void crear(ComandoOrden comandoOrden) {
		Orden orden= fabricaOrden.crear(comandoOrden);
		this.servicioCrearOrden.crear(orden);
	}
}
