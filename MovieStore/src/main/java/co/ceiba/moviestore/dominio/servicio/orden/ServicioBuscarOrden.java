package co.ceiba.moviestore.dominio.servicio.orden;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;

public class ServicioBuscarOrden {

	private final RepositorioOrden repositorioOrden;

	public ServicioBuscarOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
	}
	
	
	public ComandoOrden buscar(Orden orden) {
		return repositorioOrden.buscarCliente(orden);
	}
	
	
}
