package co.ceiba.moviestore.dominio.servicio.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionDuplicidad;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioCrearCliente {

	private static final String EL_CLIENTE_YA_EXISTE = "El cliente ya existe en el sistema";
	private RepositorioCliente repositorioCliente;

	public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void crear(Cliente cliente) {
		validarExistenciaPrevia(cliente.getCedula());
		this.repositorioCliente.crear(cliente);
	}
	
	public void validarExistenciaPrevia(String cedula) {
		boolean existe= this.repositorioCliente.existe(cedula);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE);
		}
	}
	
}
