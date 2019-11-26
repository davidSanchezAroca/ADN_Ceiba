package co.ceiba.moviestore.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioCrearSesion;
import co.ceiba.moviestore.dominio.testdatabuilder.SesionTestDataBuilder;

public class ServicioSesionTest {

	@Test
	public void passwordNoValido() {
		Sesion sesion = new SesionTestDataBuilder().build();
		sesion.setPassword("1111");
		RepositorioSesion repositorio= Mockito.mock(RepositorioSesion.class);
		ServicioCrearSesion servicioCrearSesion = new ServicioCrearSesion(repositorio);
		MovieStoreApplicationTests.assertThrows(()-> servicioCrearSesion.crear(sesion),ExcepcionGenerica.class, "El password debe tener una letra minuscula,mayuscula,digito,simbolo y debe ser de logintud entre  4 y 6");
	}

}
