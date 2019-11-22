package co.ceiba.moviestore.aplicacion.comando.manejador.categoria;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioCrearCategoria;

@Component
public class ManejadorCrearCategoria {
	
	private final ServicioCrearCategoria servicioCrearCategoria;
	
	private final FabricaCategoria fabricaCategoria;

	public ManejadorCrearCategoria(ServicioCrearCategoria servicioCrearCategoria, FabricaCategoria fabricaCategoria) {
		this.servicioCrearCategoria = servicioCrearCategoria;
		this.fabricaCategoria = fabricaCategoria;
	}



	public void crear(ComandoCategoria comandoCategoria) {
		Categoria categoria=this.fabricaCategoria.crear(comandoCategoria);
		this.servicioCrearCategoria.crear(categoria);
	}
}
