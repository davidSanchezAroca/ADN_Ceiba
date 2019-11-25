package co.ceiba.moviestore.dominio.servicio.orden;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;

public class ServicioActualizarOrden {

	private final RepositorioOrden repositorioOrden;

	public ServicioActualizarOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
	}
	
	public void actualizar(Orden orden) {
		ComandoOrden comando= buscar(orden);
		if(comando != null) {
		  orden.setNumeroOrden(comando.getNumeroOrden());
		  repositorioOrden.actualizar(orden);
		}
	}
	
	public ComandoOrden buscar(Orden orden) {
		return repositorioOrden.buscarCliente(orden);
	}
}
