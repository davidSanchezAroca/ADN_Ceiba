package co.ceiba.moviestore.aplicacion.comando.manejador;
import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.servicio.ServicioCrearCategoria;

@Component
public class ManejadorCategoria {
	
	private final ServicioCrearCategoria servicioCrearCategoria;
	
	private final FabricaCategoria fabricaCategoria;

	public ManejadorCategoria(ServicioCrearCategoria servicioCrearCategoria, FabricaCategoria fabricaCategoria) {
		this.servicioCrearCategoria = servicioCrearCategoria;
		this.fabricaCategoria = fabricaCategoria;
	}
	
	public void crear(ComandoCategoria comandoCategoria) {
		Categoria categoria=this.fabricaCategoria.crearCategoria(comandoCategoria);
		this.servicioCrearCategoria.crear(categoria);
	}
	
	public void eliminar(String nombre) {
		this.servicioCrearCategoria.eliminar(nombre);
	}

	public List<ComandoCategoria> listar(){
		return this.servicioCrearCategoria.listar();
	}
}
