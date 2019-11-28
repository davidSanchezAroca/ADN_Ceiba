package co.ceiba.moviestore.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioAsociarCategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioEliminarCategoriaPelicula;
import co.ceiba.moviestore.dominio.testdatabuilder.CategoriaPeliculaTestDataBuilder;

public class ServicioCategoriaPeliculaTest {

	@Test
	public void asociar() {
		CategoriaPelicula categoriaPelicula = new CategoriaPeliculaTestDataBuilder().build();
		RepositorioCategoriaPelicula repositorioCategoriaPelicula = Mockito.mock(RepositorioCategoriaPelicula.class);
		RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
		RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
		
		ServicioAsociarCategoriaPelicula servicio = new ServicioAsociarCategoriaPelicula(repositorioCategoriaPelicula, repositorioCategoria, repositorioPelicula);
		MovieStoreApplicationTests.assertThrows(() -> servicio.asociar(categoriaPelicula), ExcepcionGenerica.class, "No se puede asociar la categoria y pelicula");
	}
	
	@Test
	public void eliminar() {
		CategoriaPelicula categoriaPelicula = new CategoriaPeliculaTestDataBuilder().build();
		RepositorioCategoriaPelicula repositorioCategoriaPelicula = Mockito.mock(RepositorioCategoriaPelicula.class);
		RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
		RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
		
		ServicioEliminarCategoriaPelicula servicio = new ServicioEliminarCategoriaPelicula(repositorioCategoriaPelicula, repositorioPelicula, repositorioCategoria);
		MovieStoreApplicationTests.assertThrows(() -> servicio.eliminar(categoriaPelicula), ExcepcionGenerica.class, "No se puede asociar la categoria y pelicula");
	}
}
