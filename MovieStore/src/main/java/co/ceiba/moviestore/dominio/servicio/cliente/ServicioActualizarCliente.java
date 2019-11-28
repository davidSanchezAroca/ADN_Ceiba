package co.ceiba.moviestore.dominio.servicio.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;

@Component
public class ServicioActualizarCliente {

	private static final String NO_EXISTE_EL_CLIENTE = "No existe el cliente en el sistema";
	private RepositorioCliente repositorioCliente;

	public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	
	public void actualizar(Cliente cliente) {
		validarExistenciaPrevia(cliente.getCedula());
		this.repositorioCliente.actualizar(cliente);
	}
	
	public void validarExistenciaPrevia(String cedula) {
		boolean existe= this.repositorioCliente.existe(cedula);
		if(!existe) {
			throw new ExcepcionGenerica(NO_EXISTE_EL_CLIENTE);
		}
	}
}
