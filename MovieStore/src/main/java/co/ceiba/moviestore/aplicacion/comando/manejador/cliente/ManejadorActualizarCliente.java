package co.ceiba.moviestore.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCliente;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioActualizarCliente;

@Component
public class ManejadorActualizarCliente {

	private final FabricaCliente fabricaCliente;
	
	private final ServicioActualizarCliente servicioActualizarCliente;

	public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizarCliente servicioActualizarCliente) {
		this.fabricaCliente = fabricaCliente;
		this.servicioActualizarCliente = servicioActualizarCliente;
	}
	
	public void actualizar(ComandoCliente comandoCliente) {
		Cliente cliente= fabricaCliente.crear(comandoCliente);
		servicioActualizarCliente.actualizar(cliente);
	}
	
}

