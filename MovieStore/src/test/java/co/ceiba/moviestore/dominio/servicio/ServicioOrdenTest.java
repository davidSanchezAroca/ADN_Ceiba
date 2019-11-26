package co.ceiba.moviestore.dominio.servicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioCrearOrden;
import co.ceiba.moviestore.dominio.testdatabuilder.OrdenTestDataBuilder;

public class ServicioOrdenTest {

	@Test
	public void validarLunesMartes() throws ParseException {
		Orden orden= new OrdenTestDataBuilder().build();
		orden.setFechaOrden(new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-23"));
		System.out.println(orden.getFechaOrden());
		RepositorioOrden repositorio = Mockito.mock(RepositorioOrden.class);		
		ServicioCrearOrden servicioCrearOrden = new ServicioCrearOrden(repositorio);
		MovieStoreApplicationTests.assertThrows(()-> servicioCrearOrden.crear(orden),ExcepcionGenerica.class, "No se permite prestar peliculas");
		System.out.println("hola");
	}
}
