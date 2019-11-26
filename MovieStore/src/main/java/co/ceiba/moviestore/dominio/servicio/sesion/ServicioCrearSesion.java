package co.ceiba.moviestore.dominio.servicio.sesion;



import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;

public class ServicioCrearSesion {

	private final RepositorioSesion repositorioSesion;
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,6})";
	private static final String VALIDACION_PASSWORD = "El password debe tener una letra minuscula,mayuscula,digito,simbolo y debe ser de logintud entre  4 y 6";
	
	 
	
	public ServicioCrearSesion(RepositorioSesion repositorioSesion) {
		this.repositorioSesion = repositorioSesion;
	}

	public void crear(Sesion sesion) {
		validarPassword(sesion);
		repositorioSesion.crear(sesion);	
	}
	
	public void  validarPassword(Sesion sesion) {
		boolean password = sesion.getPassword().matches(PASSWORD_PATTERN);
		if(!password) {
			throw new ExcepcionGenerica(VALIDACION_PASSWORD);
		}
	}
}
