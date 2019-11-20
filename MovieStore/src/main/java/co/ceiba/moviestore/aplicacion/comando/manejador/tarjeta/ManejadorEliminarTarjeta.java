package co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioEliminarTarjeta;

@Component
public class ManejadorEliminarTarjeta {

	private final FabricaTarjeta fabricaTarjeta;
	
	private final ServicioEliminarTarjeta servicioEliminarTarjeta;

	public ManejadorEliminarTarjeta(FabricaTarjeta fabricaTarjeta, ServicioEliminarTarjeta servicioEliminarTarjeta) {
		this.fabricaTarjeta = fabricaTarjeta;
		this.servicioEliminarTarjeta = servicioEliminarTarjeta;
	}
	
	public void eliminar(ComandoTarjeta comandoTarjeta) {
		Tarjeta tarjeta = fabricaTarjeta.crearTarjeta(comandoTarjeta);
		servicioEliminarTarjeta.eliminar(tarjeta);
	}
	
	
}
