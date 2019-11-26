package co.ceiba.moviestore.dominio.servicio;
import java.text.ParseException;
import org.junit.Test;
import org.mockito.Mockito;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioCrearOrden;
import co.ceiba.moviestore.dominio.testdatabuilder.OrdenTestDataBuilder;

public class ServicioOrdenTest {

	@Test
	public void validarDomingo() throws ParseException {
		Orden orden= new OrdenTestDataBuilder().build();		
		RepositorioOrden repositorio = Mockito.mock(RepositorioOrden.class);		
		ServicioCrearOrden servicioCrearOrden = new ServicioCrearOrden(repositorio);
	}
}
