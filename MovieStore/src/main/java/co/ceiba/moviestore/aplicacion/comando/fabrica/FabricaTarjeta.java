package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;

@Component
public class FabricaTarjeta {

	public Tarjeta crearTarjeta(ComandoTarjeta comandoTarjeta) {
		return new Tarjeta(comandoTarjeta.getFranquicia(), comandoTarjeta.getNumeroCuenta(), comandoTarjeta.getCliente());
	}
}
