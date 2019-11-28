package co.ceiba.moviestore.dominio.modelo;

import org.junit.jupiter.api.Test;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.ClienteTestDataBuilder;

public class ClienteTest {
	
	@Test
	public void validarCedula() {
		ClienteTestDataBuilder cliente = new ClienteTestDataBuilder();
		cliente.setCedula(null);
		MovieStoreApplicationTests.assertThrows(() -> cliente.build(),ExcepcionValorObligatorio.class, "La cedula es un dato obligatorio");
	}
	@Test
	public void validarNombre() {
		ClienteTestDataBuilder cliente = new ClienteTestDataBuilder();
		cliente.setNombre(null);
		MovieStoreApplicationTests.assertThrows(() -> cliente.build(),ExcepcionValorObligatorio.class, "El nombre es un dato obligatorio");
	}
	@Test
	public void validarApellido() {
		ClienteTestDataBuilder cliente = new ClienteTestDataBuilder();
		cliente.setApellido(null);
		MovieStoreApplicationTests.assertThrows(() -> cliente.build(),ExcepcionValorObligatorio.class, "El apellido es un dato obligatorio");
	}
	public void validarFecha() {
		ClienteTestDataBuilder cliente = new ClienteTestDataBuilder();
		cliente.setFechaNacimiento(null);
		MovieStoreApplicationTests.assertThrows(() -> cliente.build(),ExcepcionValorObligatorio.class, "La fecha es un dato obligatorio");
	}
}
