package co.ceiba.moviestore.dominio.servicio.sesion;

import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;

public class ServicioCrearSesion {

	private final RepositorioSesion repositorioSesion;
	
	public ServicioCrearSesion(RepositorioSesion repositorioSesion) {
		this.repositorioSesion = repositorioSesion;
	}

	public void crear(Sesion sesion) {
	   repositorioSesion.crear(sesion);	
	}	
}
