package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.infraestructura.entidades.CategoriaEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.CategoriaRepositorio;

@Repository
public class RepositorioCategoriaJpa implements RepositorioCategoria {

	@Autowired
	private final CategoriaRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioCategoriaJpa(CategoriaRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(Categoria categoria) {
		CategoriaEntidad categoriaEntity = modelMapper.map(categoria, CategoriaEntidad.class);
		repositorioJpa.save(categoriaEntity);
	}

	@Override
	public boolean existe(Categoria categoria) {
		List<CategoriaEntidad> catAux;
		CategoriaEntidad categoriaEntity = modelMapper.map(categoria, CategoriaEntidad.class);
		catAux= repositorioJpa.findByNombre(categoriaEntity.getNombre());
		return !catAux.isEmpty() ;
	}

	@Override
	@Transactional
	public void eliminar(String nombre) {
		repositorioJpa.deleteByNombre(nombre);		
	}
	
	@Override
	public List<ComandoCategoria> listar() {
		List<CategoriaEntidad> listacategoriaEntidad=repositorioJpa.findAll();
		List<ComandoCategoria> listaCategorias= new ArrayList<>();
		for(int i=0; i < listacategoriaEntidad.size(); i++) {
			listaCategorias.add(modelMapper.map(listacategoriaEntidad.get(i),ComandoCategoria.class));
		}
		return listaCategorias;
	}

	@Override
	public ComandoCategoria buscar(String nombre) {
		List<CategoriaEntidad> categoriaEntidad=repositorioJpa.findByNombre(nombre);
		if(categoriaEntidad.size() > 0) {
			return  modelMapper.map(categoriaEntidad.get(0),ComandoCategoria.class);
		}
		return null;
	}



}
