package co.ceiba.moviestore.dominio.servicio.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioEliminarCliente {

	private RepositorioCliente repositorioCliente;

	public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void eliminar(String cedula) {
		repositorioCliente.eliminar(cedula);
	}
	
	
}
