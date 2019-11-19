package co.ceiba.moviestore.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCliente;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioCrearCliente;

@Component
public class ManejadorCrearCliente {

	private final FabricaCliente fabricaCliente;
	
	private final ServicioCrearCliente servicioCrearCliente;

	public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {
		this.fabricaCliente = fabricaCliente;
		this.servicioCrearCliente = servicioCrearCliente;
	}
	
	public void crear(ComandoCliente comandoCliente) {
		Cliente cliente= fabricaCliente.crear(comandoCliente);
		servicioCrearCliente.crear(cliente);
	}	
}
