package co.ceiba.moviestore.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioBuscarCliente;

@Component
public class ManejadorBuscarCliente {

	private final ServicioBuscarCliente servicioBuscarCliente;

	public ManejadorBuscarCliente(ServicioBuscarCliente servicioBuscarCliente) {
		this.servicioBuscarCliente = servicioBuscarCliente;
	}
	
	public ComandoCliente buscar(String cedula) {
		return this.servicioBuscarCliente.buscar(cedula);
	}
	
	
}
