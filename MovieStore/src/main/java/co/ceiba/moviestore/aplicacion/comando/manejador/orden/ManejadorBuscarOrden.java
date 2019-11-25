package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioBuscarOrden;

@Component
public class ManejadorBuscarOrden {

	private final ServicioBuscarOrden servicioBuscarOrden;
	private final FabricaOrden fabricaOrden;

	public ManejadorBuscarOrden(ServicioBuscarOrden servicioBuscarOrden, FabricaOrden fabricaOrden) {
		this.servicioBuscarOrden = servicioBuscarOrden;
		this.fabricaOrden=fabricaOrden;
	}
	
	public ComandoOrden buscar(ComandoOrden comandoOrden) {
		Orden orden = this.fabricaOrden.crear(comandoOrden);
		return this.servicioBuscarOrden.buscar(orden);
	}
	
	
}
