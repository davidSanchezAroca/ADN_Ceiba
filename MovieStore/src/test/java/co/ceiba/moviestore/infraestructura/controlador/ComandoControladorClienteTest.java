package co.ceiba.moviestore.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieStoreApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComandoControladorClienteTest {

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
	public void crear() throws Exception {
		ComandoCliente tarjeta = new ComandoClienteTestDataBuider().build();
		mocMvc.perform(post("/cliente/agregar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tarjeta))).andExpect(status().isOk());
	}
}
