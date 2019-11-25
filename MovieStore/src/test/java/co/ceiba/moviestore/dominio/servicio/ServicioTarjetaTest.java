package co.ceiba.moviestore.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;
import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioCrearTarjeta;
import co.ceiba.moviestore.dominio.testdatabuilder.TarjetaTestDataBuilder;

public class ServicioTarjetaTest {

	@Test
	public void validarExistenciaPrevia() {
		Tarjeta comandoTarjeta= new TarjetaTestDataBuilder().build();
		RepositorioTarjeta mock = Mockito.mock(RepositorioTarjeta.class);
	    Mockito.when(mock.existe(Mockito.any())).thenReturn(true);	    
	    ServicioCrearTarjeta servicioCrearTarjeta = new ServicioCrearTarjeta(mock);
	    MovieStoreApplicationTests.assertThrows(()->servicioCrearTarjeta.crear(comandoTarjeta), ExcepcionGenerica.class, "La tarjeta ya existe en el sistema");		
	}
	
	
}
