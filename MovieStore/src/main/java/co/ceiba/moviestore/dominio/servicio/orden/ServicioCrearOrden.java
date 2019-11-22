package co.ceiba.moviestore.dominio.servicio.orden;

import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;

public class ServicioCrearOrden {

	private final RepositorioOrden repositorioOrden;

	public ServicioCrearOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
	}
	
	public void crear(Orden orden) {
		this.repositorioOrden.crear(orden);
	}
}
