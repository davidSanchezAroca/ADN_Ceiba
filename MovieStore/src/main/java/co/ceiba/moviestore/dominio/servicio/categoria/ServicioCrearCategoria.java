package co.ceiba.moviestore.dominio.servicio.categoria;

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
		this.repositorioCategoria.crear(categoria);
	}

	private void validarExistenciaPrevia(Categoria categoria) {
		boolean existe = this.repositorioCategoria.existe(categoria);
		if(existe) {
			throw new ExcepcionDuplicidad(LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
