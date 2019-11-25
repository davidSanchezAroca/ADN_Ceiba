package co.ceiba.moviestore.infraestructura.controlador;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.ceiba.moviestore.infraestructura.controller.TarjetaControlador;

@RunWith(SpringRunner.class)
@WebMvcTest(TarjetaControlador.class)
@ComponentScan("co.ceiba")
public class ComandoControladorTarjetaTest {

	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
    private MockMvc mocMvc;
	
	
	
	public void crear() {
		
	}
}
