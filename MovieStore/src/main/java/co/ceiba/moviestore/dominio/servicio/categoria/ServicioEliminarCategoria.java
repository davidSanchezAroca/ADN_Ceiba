package co.ceiba.moviestore.dominio.servicio.categoria;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;

@Component
public class ServicioEliminarCategoria {
	
	private RepositorioCategoria repositorioCategoria;

	public ServicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}
	
	public void eliminar(String  nombre) {
		this.repositorioCategoria.eliminar(nombre);
	}

}
