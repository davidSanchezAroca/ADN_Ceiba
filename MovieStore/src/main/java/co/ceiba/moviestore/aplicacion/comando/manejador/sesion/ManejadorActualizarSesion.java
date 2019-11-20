package co.ceiba.moviestore.aplicacion.comando.manejador.sesion;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoSesion;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaSesion;
import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioActualizarSesion;

@Component
public class ManejadorActualizarSesion {

	private final FabricaSesion fabricaSesion;
	
	private final ServicioActualizarSesion servicioActualizarSesion;

	public ManejadorActualizarSesion(FabricaSesion fabricaSesion, ServicioActualizarSesion servicioActualizarSesion) {
		this.fabricaSesion = fabricaSesion;
		this.servicioActualizarSesion = servicioActualizarSesion;
	}
	
	public void actualizar(ComandoSesion comandoSesion) {
		Sesion sesion= this.fabricaSesion.crear(comandoSesion);
		servicioActualizarSesion.actualizar(sesion);
	}
	
	
}
