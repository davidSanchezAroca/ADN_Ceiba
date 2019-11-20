package co.ceiba.moviestore.aplicacion.comando.manejador.sesion;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoSesion;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaSesion;
import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioCrearSesion;

@Component
public class ManejadorCrearSesion {

	private final FabricaSesion fabricaSesion;
	
	private final ServicioCrearSesion servicioCrearSesion;

	public ManejadorCrearSesion(FabricaSesion fabricaSesion, ServicioCrearSesion servicioCrearSesion) {
		this.fabricaSesion = fabricaSesion;
		this.servicioCrearSesion = servicioCrearSesion;
	}
	
	public void crear(ComandoSesion comandoSesion) {
		Sesion sesion = this.fabricaSesion.crear(comandoSesion);
		servicioCrearSesion.crear(sesion);
	}
	
	
}
