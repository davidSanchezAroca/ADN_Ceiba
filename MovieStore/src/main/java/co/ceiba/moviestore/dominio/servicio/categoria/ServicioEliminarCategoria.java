package co.ceiba.moviestore.dominio.servicio.categoria;

import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;

public class ServicioEliminarCategoria {
	
	private final RepositorioCategoria repositorioCategoria;

	public ServicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}
	
	public void eliminar(String  nombre) {
		this.repositorioCategoria.eliminar(nombre);
	}

}
