package co.ceiba.moviestore.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionDuplicidad;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.testdatabuilder.CategoriaTestDataBuilder;

public class ServicioCrearCategoriaTest {

	@Test
	public void validarExistenciaPrevia() {
		Categoria cat= new CategoriaTestDataBuilder().build();
		RepositorioCategoria repoCat= Mockito.mock(RepositorioCategoria.class);
		Mockito.when(repoCat.existeCategoria(Mockito.any())).thenReturn(true);
		
		ServicioCrearCategoria servicioCrearCategoria = new ServicioCrearCategoria(repoCat);
		
		MovieStoreApplicationTests.assertThrows(() -> servicioCrearCategoria.crear(cat), ExcepcionDuplicidad.class, "La categoria ya existe en el sistema");
	}
}
