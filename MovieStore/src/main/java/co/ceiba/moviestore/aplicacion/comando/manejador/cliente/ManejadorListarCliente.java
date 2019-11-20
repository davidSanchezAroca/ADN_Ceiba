package co.ceiba.moviestore.aplicacion.comando.manejador.cliente;

import java.util.List;

import org.springframework.stereotype.Component;
import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioListarCliente;

@Component
public class ManejadorListarCliente {

	private final ServicioListarCliente servicioListarCliente;

	public ManejadorListarCliente(ServicioListarCliente servicioListarCliente) {
		this.servicioListarCliente = servicioListarCliente;
	}
	
	
	public List<ComandoCliente> listar(){
		return servicioListarCliente.listar();
	}
	
	
}
