package co.ceiba.moviestore.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPeliculaOrden;
import co.ceiba.moviestore.dominio.servicio.pelicula.orden.ServicioActualizarPeliculaOrden;
import co.ceiba.moviestore.dominio.testdatabuilder.PeliculaOrdenTestDataBuilder;

public class ServicioPeliculaOrdenTest {

	@Test
	public void actualizar() {
		PeliculaOrden  peliculaOrden =  new PeliculaOrdenTestDataBuilder().build();
		RepositorioPeliculaOrden repositorioPeliculaOrden = Mockito.mock(RepositorioPeliculaOrden.class);
		RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
		RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
		ServicioActualizarPeliculaOrden servicio= new ServicioActualizarPeliculaOrden(repositorioPeliculaOrden, repositorioPelicula, repositorioOrden);
		MovieStoreApplicationTests.assertThrows(()-> servicio.actualizar(peliculaOrden),ExcepcionGenerica.class, "No existe los elementos a eliminar");
		
	}
}
