package co.ceiba.moviestore.dominio.modelo;

import org.junit.jupiter.api.Test;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.PeliculaTestDataBuilder;

public class PeliculaTest {
	
	@Test
	public void validarNombre() {
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder();
		pelicula.setNombre(null);
		MovieStoreApplicationTests.assertThrows(() -> pelicula.build(),ExcepcionValorObligatorio.class, "El nombre es un dato obligatorio.");
	}
	@Test
	public void validarValor() {
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder();
		pelicula.setValor(0); 
		MovieStoreApplicationTests.assertThrows(() -> pelicula.build(),ExcepcionValorObligatorio.class, "El valor es un dato obligatorio");
	}

}
