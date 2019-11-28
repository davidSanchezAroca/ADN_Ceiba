package co.ceiba.moviestore.dominio.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionDuplicidad;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioCrearCliente;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioEliminarCliente;
import co.ceiba.moviestore.dominio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioClienteTest {
	
	@Test
	public void validarExistenciaPrevia() {
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);
		
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
		
		MovieStoreApplicationTests.assertThrows(() -> servicioCrearCliente.crear(cliente), ExcepcionDuplicidad.class, "El cliente ya existe en el sistema");
	}
	@Test
	public void validarExistenciaPreviaEliminar() {
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(false);
		
		ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
		
		MovieStoreApplicationTests.assertThrows(() -> servicioEliminarCliente.eliminar(cliente.getCedula()), ExcepcionGenerica.class, "El cliente no existe en el sistema");
	}
}
