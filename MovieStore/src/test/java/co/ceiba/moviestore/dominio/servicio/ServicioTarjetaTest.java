package co.ceiba.moviestore.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.ComandoTarjetaTestDataBuilder;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioBuscarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioCrearTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioEliminarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioListarTarjeta;
import co.ceiba.moviestore.dominio.testdatabuilder.TarjetaTestDataBuilder;

public class ServicioTarjetaTest {

	@Test
	public void validarExistenciaPreviaAgregar() {
		Tarjeta comandoTarjeta= new TarjetaTestDataBuilder().build();
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
	    Mockito.when(mock.existe(Mockito.any())).thenReturn(true);	    
	    ServicioCrearTarjeta servicioCrearTarjeta = new ServicioCrearTarjeta(mock);
	    MovieStoreApplicationTests.assertThrows(()->servicioCrearTarjeta.crear(comandoTarjeta), ExcepcionGenerica.class, "La tarjeta ya existe en el sistema");		
	}
	
	@Test
	public void validarExistenciaPreviaEliminar() {
		Tarjeta tarjeta= new TarjetaTestDataBuilder().build();
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
		Mockito.when(mock.existe(Mockito.any())).thenReturn(false);
		ServicioEliminarTarjeta servicioEliminarTarjeta= new ServicioEliminarTarjeta(mock);
		MovieStoreApplicationTests.assertThrows(()-> servicioEliminarTarjeta.eliminar(tarjeta), ExcepcionGenerica.class, "No existe tarjeta en el sistema");
	}
	
	@Test
	public void listar() {
		List<ComandoTarjeta> list = new ArrayList<>();
		list.add(new ComandoTarjetaTestDataBuilder().build());
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
		Mockito.when(mock.listar(Mockito.any())).thenReturn(list);
		ServicioListarTarjeta servicioListarTarjeta = new ServicioListarTarjeta(mock);
		assertEquals(servicioListarTarjeta.listar("111").size(), 1);
	}
	
	
	@Test
	public void validarNoExistenciaTarjeta() {
		Tarjeta tarjeta = new TarjetaTestDataBuilder().build();
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
		Mockito.when(mock.buscar(Mockito.any())).thenReturn(null);	
		ServicioBuscarTarjeta servicioBuscarTarjeta = new ServicioBuscarTarjeta(mock);
		MovieStoreApplicationTests.assertThrows(()-> servicioBuscarTarjeta.buscar(tarjeta), ExcepcionGenerica.class, "No exite la tarjeta asociada");
	}
	
	@Test
	public void validarExistenciaTarjeta() {
		Tarjeta tarjeta = new TarjetaTestDataBuilder().build();
		ComandoTarjeta comandoTarjeta = new ComandoTarjetaTestDataBuilder().build();
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
		Mockito.when(mock.buscar(Mockito.any())).thenReturn(comandoTarjeta);
		ServicioBuscarTarjeta servicioBuscarTarjeta = new ServicioBuscarTarjeta(mock);
		assertEquals(servicioBuscarTarjeta.buscar(tarjeta).getNumeroCuenta(), "1234567891234567");
	}

}
