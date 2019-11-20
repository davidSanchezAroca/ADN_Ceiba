package co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioBuscarTarjeta;

@Component
public class ManejadorBuscarTarjeta {

	private final ServicioBuscarTarjeta servicioBuscarTarjeta;

	public ManejadorBuscarTarjeta(ServicioBuscarTarjeta servicioBuscarTarjeta) {
		this.servicioBuscarTarjeta = servicioBuscarTarjeta;
	}
	
	public ComandoTarjeta buscar(String numero) {
		return this.servicioBuscarTarjeta.buscar(numero);
	}
	
	
}
