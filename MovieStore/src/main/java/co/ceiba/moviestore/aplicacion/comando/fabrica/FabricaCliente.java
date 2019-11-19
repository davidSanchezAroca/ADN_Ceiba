package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.modelo.Cliente;

@Component
public class FabricaCliente {
	
	public Cliente crear(ComandoCliente comandoCliente) {
		return new Cliente(comandoCliente.getCedula(), comandoCliente.getNombre()
				,comandoCliente.getApellido(), comandoCliente.getFechaNacimiento());
	}
}
