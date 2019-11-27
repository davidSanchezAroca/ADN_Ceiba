package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioPrecioOrden;

@Component
public class ManejadorPrecioOrden {

	private final FabricaOrden fabricaOrden;
	
	private final ServicioPrecioOrden servicioPrecio;

	public ManejadorPrecioOrden(FabricaOrden fabricaOrden, ServicioPrecioOrden servicioPrecio) {
		this.fabricaOrden = fabricaOrden;
		this.servicioPrecio = servicioPrecio;
	}
	
	public void precio(ComandoOrden comandoOrden) {
		Orden orden = this.fabricaOrden.crear(comandoOrden);
		this.servicioPrecio.precio(orden);
	}
}
