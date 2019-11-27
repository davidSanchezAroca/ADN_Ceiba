package co.ceiba.moviestore.dominio.modelo;

import java.text.ParseException;

import org.junit.Test;

import co.ceiba.moviestore.MovieStoreApplicationTests;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;
import co.ceiba.moviestore.dominio.testdatabuilder.OrdenTestDataBuilder;

public class OrdenTest {

	@Test
	public void validarFechaOrden() throws ParseException {
		OrdenTestDataBuilder orden= new OrdenTestDataBuilder();	
		orden.setFechaOrden(null);
		MovieStoreApplicationTests.assertThrows(() -> orden.build(),ExcepcionValorObligatorio.class, "La fecha no cuenta con un valor asignado");
	}
	
	@Test
	public void validarFechaInicio() throws ParseException {
		OrdenTestDataBuilder orden= new OrdenTestDataBuilder();	
		orden.setFechaInicio(null);
		MovieStoreApplicationTests.assertThrows(() -> orden.build(),ExcepcionValorObligatorio.class, "La fecha no cuenta con un valor asignado");
	}
	
	@Test
	public void validarFechaFin() throws ParseException {
		OrdenTestDataBuilder orden= new OrdenTestDataBuilder();	
		orden.setFechaFin(null);
		MovieStoreApplicationTests.assertThrows(() -> orden.build(),ExcepcionValorObligatorio.class, "La fecha no cuenta con un valor asignado");
	}
	
	@Test
	public void validarCliente() throws ParseException {
		OrdenTestDataBuilder orden= new OrdenTestDataBuilder();	
		orden.getCliente().setCedula(null);
		MovieStoreApplicationTests.assertThrows(() -> orden.build(),ExcepcionValorObligatorio.class, "No hay informacion del cliente");
	}
}
