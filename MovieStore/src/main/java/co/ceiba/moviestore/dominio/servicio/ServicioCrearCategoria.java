package co.ceiba.moviestore.dominio.servicio;


import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionDuplicidad;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;

@Component
public class ServicioCrearCategoria {

	private static final String LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA = "La categoria ya existe en el sistema";
	
	private RepositorioCategoria repositorioCategoria;

	public ServicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}
	
	public void crear(Categoria categoria) {
		validarExistenciaPrevia(categoria);
		this.repositorioCategoria.crearCategoria(categoria);
	}

	private void validarExistenciaPrevia(Categoria pelicula) {
		boolean existe = this.repositorioCategoria.existeCategoria(pelicula);
		if(existe) {
			throw new ExcepcionDuplicidad(LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
