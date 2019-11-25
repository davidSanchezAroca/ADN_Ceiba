package co.ceiba.moviestore.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaTestDataBuilder;
import co.ceiba.moviestore.infraestructura.controller.CategoriaControlador;


@RunWith(SpringRunner.class)
@WebMvcTest(CategoriaControlador.class)
@ComponentScan({ "co.*" })
public class ComandoControladorCategoriaTest {
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
    private MockMvc mocMvc;
	
	@Test
	public void crear() throws JsonProcessingException, Exception {
		
		ComandoCategoria categoria= new ComandoCategoriaTestDataBuilder().build();
		mocMvc.perform(post("/categoria/agregar")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(categoria)))
        		.andExpect(status().isOk());
	}

}
