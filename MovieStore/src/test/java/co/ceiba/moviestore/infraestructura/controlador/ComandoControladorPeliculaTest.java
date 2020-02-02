package co.ceiba.moviestore.infraestructura.controlador;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieStoreApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComandoControladorPeliculaTest {

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
		ComandoPelicula comandoPelicula = new ComandoPeliculaTestDataBuilder().build();
		mocMvc.perform(post("/pelicula/agregar").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(comandoPelicula))).andExpect(status().isOk());
	}
	
	@Test
	public void eliminar() throws Exception {
		crear();
		mocMvc.perform(delete("/pelicula/eliminar/Avengers").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	

	@Test
	public void listar() throws Exception {
		crear();
		mocMvc.perform(get("/pelicula/listar").contentType(MediaType.APPLICATION_JSON)).
		andExpect(status().isOk()).
		andExpect(jsonPath("$", hasSize(1))).
		andExpect(jsonPath("$[0].nombre", is("Avengers")));
	}
	
	@Test
	public void actualizar() throws Exception {
		crear();
		ComandoPelicula comandoPelicula = new ComandoPeliculaTestDataBuilder().build();
		comandoPelicula.setNombre("hola");
		mocMvc.perform(post("/pelicula/actualizar").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(comandoPelicula))).andExpect(status().isOk());

	}
}
