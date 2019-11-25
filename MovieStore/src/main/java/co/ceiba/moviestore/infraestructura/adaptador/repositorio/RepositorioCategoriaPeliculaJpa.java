
package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoriaPelicula;
import co.ceiba.moviestore.dominio.modelo.CategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoriaPelicula;
import co.ceiba.moviestore.infraestructura.entidades.CategoriaPeliculaEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.CategoriaPeliculaRepositorio;

@Repository
public class RepositorioCategoriaPeliculaJpa  implements RepositorioCategoriaPelicula{

	@Autowired
	private final CategoriaPeliculaRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioCategoriaPeliculaJpa(CategoriaPeliculaRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	@Transactional
	public void asociar(CategoriaPelicula categoriaPelicula) {
		CategoriaPeliculaEntidad categoriaPeliculaEntidad= modelMapper.map(categoriaPelicula, CategoriaPeliculaEntidad.class);
		this.repositorioJpa.saveEntidad(categoriaPeliculaEntidad.getIdCategoria().getIdCategoria(), categoriaPeliculaEntidad.getIdPelicula().getIdProducto());
	}

	@Override
	@Transactional
	public void eliminar(int categoria,int pelicula) {
		this.repositorioJpa.deleteByPeliculaCategoria(categoria, pelicula);
	}

	@Override
	public List<ComandoCategoriaPelicula> listar() {
		List<CategoriaPeliculaEntidad> list= repositorioJpa.findAll();
		List<ComandoCategoriaPelicula> resList=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			resList.add(modelMapper.map(list.get(i),ComandoCategoriaPelicula.class));
		}
		return resList;
	}

}
