package co.ceiba.moviestore.aplicacion.comando.manejador.categoria.pelicula;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.aplicacion.comando.fabrica.FabricaCategoriaPelicula;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioAsociarCategoriaPelicula;

@Component
public class ManejadorAsociarCategoriaPelicula {

	private final ServicioAsociarCategoriaPelicula servicioAsociarCategoriaPelicula;
	
	private final FabricaCategoriaPelicula fabricaCategoriaPelicula;

	public ManejadorAsociarCategoriaPelicula(ServicioAsociarCategoriaPelicula servicioAsociarCategoriaPelicula,
			FabricaCategoriaPelicula fabricaCategoriaPelicula) {
		this.servicioAsociarCategoriaPelicula = servicioAsociarCategoriaPelicula;
		this.fabricaCategoriaPelicula = fabricaCategoriaPelicula;
	}
	
	public void asociar(ComandoCategoriaPelicula comandoCategoriaPelicula) {
		CategoriaPelicula categoriaPelicula = fabricaCategoriaPelicula.crear(comandoCategoriaPelicula);
		this.servicioAsociarCategoriaPelicula.asociar(categoriaPelicula);
	}
	
	
}
