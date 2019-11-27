package co.ceiba.moviestore.dominio.modelo;

import org.junit.Test;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.SesionTestDataBuilder;

public class SesionTest {
	
	@Test
	public void validarPassword() {		
		SesionTestDataBuilder sesionTestDataBuilder =  new SesionTestDataBuilder();
		sesionTestDataBuilder.setPassword("");
		MovieStoreApplicationTests.assertThrows(() -> sesionTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La informacion se encuentra incompleta");
	}
	
	@Test
	public void validarUsuario() {
		SesionTestDataBuilder sesionTestDataBuilder =  new SesionTestDataBuilder();
		sesionTestDataBuilder.setUsuario("");
		MovieStoreApplicationTests.assertThrows(() -> sesionTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La informacion se encuentra incompleta");
	}
	
	@Test
	public void validarCliente() {
		SesionTestDataBuilder sesionTestDataBuilder =  new SesionTestDataBuilder();
		sesionTestDataBuilder.getCliente().setCedula("");
		MovieStoreApplicationTests.assertThrows(() -> sesionTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La informacion se encuentra incompleta");
	}

}
