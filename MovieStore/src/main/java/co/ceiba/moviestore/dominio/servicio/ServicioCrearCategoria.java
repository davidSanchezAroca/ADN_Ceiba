package co.ceiba.moviestore.dominio.servicio;


import java.util.List;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionDuplicidad;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;

@Component
public class ServicioCrearCategoria {

	private static final String LA_CATEGORIA_YA_EXISTE_EN_EL_SISTEMA = "La categoria ya existe en el sistema";
	private static final String NO_EXISTE_LA_CATEGORIA_EN_EL_SISTEMA="No existe la categoria en el sistema";
	
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
	
	public List<ComandoCategoria> listar(){
		return this.repositorioCategoria.listar();
	}
	
	public void eliminar(String  nombre) {
			this.repositorioCategoria.eliminar(nombre);
	}
	
	
}
