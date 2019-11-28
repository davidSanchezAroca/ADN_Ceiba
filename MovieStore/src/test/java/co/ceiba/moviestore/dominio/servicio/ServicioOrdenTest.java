package co.ceiba.moviestore.dominio.servicio;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.aplicacion.comando.ComandoOrdenTestDataBuilder;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioActualizarOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioCrearOrden;
import co.ceiba.moviestore.dominio.testdatabuilder.OrdenTestDataBuilder;

public class ServicioOrdenTest {

	@Test
	public void validarLunesMartes() throws ParseException {
		Orden orden= new OrdenTestDataBuilder().build();
		RepositorioOrden repositorio = Mockito.mock(RepositorioOrden.class);		
		ServicioCrearOrden servicioCrearOrden = new ServicioCrearOrden(repositorio);
		orden.setFechaOrden(new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-25"));
		MovieStoreApplicationTests.assertThrows(()-> servicioCrearOrden.crear(orden),ExcepcionGenerica.class, "No se permite prestar peliculas");
	}
	
	
	@Test
	public void actualizar() throws ParseException {
		Orden orden= new OrdenTestDataBuilder().build();
		ComandoOrden comando= new ComandoOrdenTestDataBuilder().build();
		RepositorioOrden repositorio = Mockito.mock(RepositorioOrden.class);		
		Mockito.when(repositorio.buscarCliente(Mockito.any())).thenReturn(comando);
		ServicioActualizarOrden servicio= new ServicioActualizarOrden(repositorio);
		servicio.actualizar(orden);
		assertEquals(orden.getNumeroOrden(), comando.getNumeroOrden());
	}
	
	
	
}
