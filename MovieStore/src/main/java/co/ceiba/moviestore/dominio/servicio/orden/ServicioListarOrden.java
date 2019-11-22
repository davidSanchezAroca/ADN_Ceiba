package co.ceiba.moviestore.dominio.servicio.orden;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;

public class ServicioListarOrden {

	private final RepositorioOrden repositorioOrden;

	public ServicioListarOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
	}
	
	public List<ComandoOrden> listar(){
		return repositorioOrden.listar();
	}
	
}
