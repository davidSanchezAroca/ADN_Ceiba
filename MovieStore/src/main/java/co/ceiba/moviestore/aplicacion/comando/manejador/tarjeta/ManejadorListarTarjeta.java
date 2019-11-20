package co.ceiba.moviestore.aplicacion.comando.manejador.tarjeta;

import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioListarTarjeta;

@Component
public class ManejadorListarTarjeta {

	private final ServicioListarTarjeta servicioListarTarjeta;

	public ManejadorListarTarjeta(ServicioListarTarjeta servicioListarTarjeta) {
		this.servicioListarTarjeta = servicioListarTarjeta;
	}
	
	public List<ComandoTarjeta> listar(String cedula){
		return this.servicioListarTarjeta.listar(cedula);
	}
}
