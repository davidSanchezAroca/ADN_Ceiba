package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoSesion;
import co.ceiba.moviestore.dominio.modelo.Sesion;

@Component
public class FabricaSesion {

	public Sesion crear(ComandoSesion comandoSesion) {
		return new Sesion(comandoSesion.getUsuario(), comandoSesion.getPassword(), comandoSesion.getCliente());
	}
}
