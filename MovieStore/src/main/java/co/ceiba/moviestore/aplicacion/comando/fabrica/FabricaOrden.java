package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;

@Component
public class FabricaOrden {

	public Orden crear(ComandoOrden comandoOrden) {
		return new Orden(comandoOrden.getNumeroOrden(),
				comandoOrden.getFechaOrden(),
				comandoOrden.getFechaInicio(),
				comandoOrden.getFechaFin(),
				comandoOrden.getValor(),
				comandoOrden.getCliente());
	}
}
