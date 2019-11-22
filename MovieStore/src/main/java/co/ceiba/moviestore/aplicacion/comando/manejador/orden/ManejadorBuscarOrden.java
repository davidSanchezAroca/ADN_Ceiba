package co.ceiba.moviestore.aplicacion.comando.manejador.orden;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioBuscarOrden;

@Component
public class ManejadorBuscarOrden {

	private ServicioBuscarOrden servicioBuscarOrden;

	public ManejadorBuscarOrden(ServicioBuscarOrden servicioBuscarOrden) {
		this.servicioBuscarOrden = servicioBuscarOrden;
	}
	
	public ComandoOrden buscar(int numero) {
		return this.servicioBuscarOrden.buscar(numero);
	}
	
	
}
