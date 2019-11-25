package co.ceiba.moviestore.dominio.servicio.categoria;
import java.util.List;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;


public class ServicioConsultarCategorias {
	
	private final RepositorioCategoria repositorioCategoria;

	public ServicioConsultarCategorias(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}
	
	public List<ComandoCategoria> listar(){
		return this.repositorioCategoria.listar();
	}
	
}
