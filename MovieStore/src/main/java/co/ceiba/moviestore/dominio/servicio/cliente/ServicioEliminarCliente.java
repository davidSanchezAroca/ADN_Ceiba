package co.ceiba.moviestore.dominio.servicio.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioEliminarCliente {

	private static final String EL_CLIENTE_NO_EXISTE = "El cliente no existe en el sistema";
	private RepositorioCliente repositorioCliente;

	public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void eliminar(String cedula) {
		validarExistenciaPrevia(cedula);
		repositorioCliente.eliminar(cedula);
	}
	
	public void validarExistenciaPrevia(String cedula) {
		boolean existe= this.repositorioCliente.existe(cedula);
		if(!existe) {
			throw new ExcepcionGenerica(EL_CLIENTE_NO_EXISTE);
		}
	}
	
}
