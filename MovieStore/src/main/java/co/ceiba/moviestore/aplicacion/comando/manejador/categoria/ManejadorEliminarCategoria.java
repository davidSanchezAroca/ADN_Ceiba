package co.ceiba.moviestore.aplicacion.comando.manejador.categoria;

import org.springframework.stereotype.Component;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioEliminarCategoria;

@Component
public class ManejadorEliminarCategoria {

	private final ServicioEliminarCategoria servicioEliminarCategoria;
	
	public ManejadorEliminarCategoria(ServicioEliminarCategoria servicioEliminarCategoria) {
		this.servicioEliminarCategoria = servicioEliminarCategoria;
	}

	public void eliminar(String nombre) {
		this.servicioEliminarCategoria.eliminar(nombre);
	}
}
