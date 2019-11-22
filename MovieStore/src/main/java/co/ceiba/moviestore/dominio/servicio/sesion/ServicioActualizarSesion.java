package co.ceiba.moviestore.dominio.servicio.sesion;

import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;

public class ServicioActualizarSesion {
	
	private final RepositorioSesion repositorioSesion;
	
	public ServicioActualizarSesion(RepositorioSesion repositorioSesion) {
		this.repositorioSesion = repositorioSesion;
	}
	
	public void actualizar(Sesion sesion) {
		repositorioSesion.actualizar(sesion);
	}
}
