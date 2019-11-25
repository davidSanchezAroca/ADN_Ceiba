package co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioBuscarTarjeta;

@Component
public class ManejadorBuscarTarjeta {

	private final ServicioBuscarTarjeta servicioBuscarTarjeta;
	
	private final FabricaTarjeta fabricaTarjeta;

	public ManejadorBuscarTarjeta(ServicioBuscarTarjeta servicioBuscarTarjeta, FabricaTarjeta fabricaTarjeta) {
		this.servicioBuscarTarjeta = servicioBuscarTarjeta;
		this.fabricaTarjeta = fabricaTarjeta;
	}
	
	public ComandoTarjeta buscar(ComandoTarjeta comandoTarjeta) {
		Tarjeta tarjeta= fabricaTarjeta.crearTarjeta(comandoTarjeta);
		return this.servicioBuscarTarjeta.buscar(tarjeta);
	}
	
	
}
