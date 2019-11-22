package co.ceiba.moviestore.dominio.servicio.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioBuscarCliente {

	private RepositorioCliente repositorioCliente;

	public ServicioBuscarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public ComandoCliente buscar(String cedula) {
		return this.repositorioCliente.buscar(cedula);
	}
	
	
}
