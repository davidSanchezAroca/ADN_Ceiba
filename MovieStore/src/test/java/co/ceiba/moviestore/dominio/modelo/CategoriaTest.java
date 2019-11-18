package co.ceiba.moviestore.dominio.modelo;
import org.junit.Test;
import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.CategoriaTestDataBuilder;

public class CategoriaTest {

	@Test
	public void validarNombreCategoria() {
		CategoriaTestDataBuilder categoria= new CategoriaTestDataBuilder();	
		categoria.setNombre(null);
		MovieStoreApplicationTests.assertThrows(() -> categoria.build(),ExcepcionValorObligatorio.class, "El nombre es un dato obligatorio.");
	}
}
