package co.ceiba.moviestore.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioEliminarCliente;

@Component
public class ManejadorEliminarCliente {

	
	private final ServicioEliminarCliente servicioEliminarCliente;

	public ManejadorEliminarCliente( ServicioEliminarCliente servicioEliminarCliente) {
		this.servicioEliminarCliente = servicioEliminarCliente;
	}
	
	public void eliminar(String cedula) {
		servicioEliminarCliente.eliminar(cedula);
	}
	
	
}
