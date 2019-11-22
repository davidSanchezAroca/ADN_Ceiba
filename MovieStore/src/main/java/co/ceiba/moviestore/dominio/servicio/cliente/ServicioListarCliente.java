package co.ceiba.moviestore.dominio.servicio.cliente;

import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioListarCliente {

	private RepositorioCliente repositorioCliente;

	public ServicioListarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public List<ComandoCliente> listar(){
		return repositorioCliente.listar();
	}
	
	
}
