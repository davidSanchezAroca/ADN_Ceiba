package co.ceiba.moviestore.aplicacion.comando.manejador.categoria;
import java.util.List;
import org.springframework.stereotype.Component;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioConsultarCategorias;

@Component
public class ManejadorConsultarCategorias {
	
	private final ServicioConsultarCategorias servicioConsultaCategorias;
	
	public ManejadorConsultarCategorias(ServicioConsultarCategorias servicioCrearCategoria) {
		this.servicioConsultaCategorias = servicioCrearCategoria;
	}
	
	public List<ComandoCategoria> listar(){
		return this.servicioConsultaCategorias.listar();
	}
	
}
