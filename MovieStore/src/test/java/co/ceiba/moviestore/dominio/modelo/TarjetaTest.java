package co.ceiba.moviestore.dominio.modelo;

import org.junit.Test;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.TarjetaTestDataBuilder;

public class TarjetaTest {
	
	@Test
	public void validarNumeroTarjeta() {
	    TarjetaTestDataBuilder tarjetaDataBuilder = new TarjetaTestDataBuilder();
	    tarjetaDataBuilder.setNumeroCuenta("");
	    MovieStoreApplicationTests.assertThrows(() -> tarjetaDataBuilder.build(), ExcepcionValorObligatorio.class, "La información se encuentra incompleta");
	}
	
	@Test
	public void validarFranquicia() {
		TarjetaTestDataBuilder tarjetaDataBuilder = new TarjetaTestDataBuilder();
	    tarjetaDataBuilder.setFranquicia("");
	    MovieStoreApplicationTests.assertThrows(() -> tarjetaDataBuilder.build(), ExcepcionValorObligatorio.class, "La información se encuentra incompleta");
	}
	
	@Test
	public void validarCedulaCliente() {
		TarjetaTestDataBuilder tarjetaDataBuilder = new TarjetaTestDataBuilder();
	    tarjetaDataBuilder.getCliente().setCedula("");
	    MovieStoreApplicationTests.assertThrows(() -> tarjetaDataBuilder.build(), ExcepcionValorObligatorio.class, "La información se encuentra incompleta");
	}
	
	
	@Test
	public void validarDigitosTarjeta() {
		TarjetaTestDataBuilder tarjetaDataBuilder = new TarjetaTestDataBuilder();
	    tarjetaDataBuilder.setNumeroCuenta("123");
	    MovieStoreApplicationTests.assertThrows(() -> tarjetaDataBuilder.build(), ExcepcionGenerica.class, "La tarjeta no cuenta con 16 digitos");
	}
	
	
}
