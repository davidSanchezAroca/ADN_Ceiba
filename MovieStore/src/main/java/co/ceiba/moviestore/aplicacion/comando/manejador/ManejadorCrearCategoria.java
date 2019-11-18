package co.ceiba.moviestore.aplicacion.comando.manejador;
import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.servicio.ServicioCrearCategoria;

@Component
public class ManejadorCrearCategoria {
	
	private final ServicioCrearCategoria servicioCrearCategoria;
	
	private final FabricaCategoria fabricaCategoria;

	public ManejadorCrearCategoria(ServicioCrearCategoria servicioCrearCategoria, FabricaCategoria fabricaCategoria) {
		super();
		this.servicioCrearCategoria = servicioCrearCategoria;
		this.fabricaCategoria = fabricaCategoria;
	}
	
	public void crear(ComandoCategoria comandoCategoria) {
		System.out.println("hola");
		Categoria categoria=this.fabricaCategoria.crearCategoria(comandoCategoria);
		this.servicioCrearCategoria.crear(categoria);
	}

}
