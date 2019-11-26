package co.ceiba.moviestore.infraestructura.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.ceiba.moviestore.MovieStoreApplication;
import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.aplicacion.comando.ComandoClienteTestDataBuider;
import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.aplicacion.comando.ComandoTarjetaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieStoreApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComandoControladorTarjetaTest {


	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setup() throws Exception {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void crear() throws Exception{
		ComandoCliente cliente = new ComandoClienteTestDataBuider().build();
		mocMvc.perform(post("/cliente/agregar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente))).andExpect(status().isOk());
		
		ComandoTarjeta tarjeta = new ComandoTarjetaTestDataBuilder().build();
		mocMvc.perform(post("/tarjeta/agregar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tarjeta))).andExpect(status().isOk());	
	}
	
	@Test
	public void eliminar() throws Exception{		
		crear();
		ComandoTarjeta tarjeta = new ComandoTarjetaTestDataBuilder().build();
		mocMvc.perform(delete("/tarjeta/eliminar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tarjeta))).andExpect(status().isOk());
	}
	
	@Test
	public void eliminarError() throws Exception{
		ComandoTarjeta tarjeta = new ComandoTarjetaTestDataBuilder().build();
		mocMvc.perform(delete("/tarjeta/eliminar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tarjeta))).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void listar() throws Exception {
		crear();
		mocMvc.perform(get("/tarjeta/listar/123").contentType(MediaType.APPLICATION_JSON)).
		andExpect(status().isOk()).
		andExpect(jsonPath("$", hasSize(1))).
		andExpect(jsonPath("$[0].numeroCuenta", is("1234567891234567")));
	}
	
	@Test
	public void buscar() throws Exception {
		crear();
		ComandoTarjeta tarjeta = new ComandoTarjetaTestDataBuilder().build();
		mocMvc.perform(put("/tarjeta/buscar").contentType(MediaType.APPLICATION_JSON).
				content(objectMapper.writeValueAsBytes(tarjeta))).andExpect(status().isOk());
	}
}
