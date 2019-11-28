package co.ceiba.moviestore.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaTestDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieStoreApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComandoControladorCategoria {

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
		ComandoCategoria cliente = new ComandoCategoriaTestDataBuilder().build();
		mocMvc.perform(post("/categoria/agregar").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente))).andExpect(status().isOk());
	}
	
	@Test
	public void eliminar() throws Exception {
		crear();
		mocMvc.perform(delete("/categoria/eliminar/terror").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
