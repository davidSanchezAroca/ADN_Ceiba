package co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioCrearTarjeta;

@Component
public class ManejadorCrearTarjeta {

	private final FabricaTarjeta fabricaTarjeta;
	
	private final ServicioCrearTarjeta servicioCrearTarjeta;

	public ManejadorCrearTarjeta(FabricaTarjeta fabricaTarjeta, ServicioCrearTarjeta servicioCrearTarjeta) {
		this.fabricaTarjeta = fabricaTarjeta;
		this.servicioCrearTarjeta = servicioCrearTarjeta;
	}
	
	public void crear(ComandoTarjeta comandoTarjeta) {
		Tarjeta tarjeta= fabricaTarjeta.crearTarjeta(comandoTarjeta);
		this.servicioCrearTarjeta.crear(tarjeta);
	}
	
	
}
