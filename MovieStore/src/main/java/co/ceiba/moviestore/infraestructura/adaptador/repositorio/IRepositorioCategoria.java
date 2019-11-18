package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.dominio.modelo.Categoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.infraestructura.entidades.CategoriaEntity;
import co.ceiba.moviestore.infraestructura.repositoriojpa.ICategoriaRepository;

@Repository
public class IRepositorioCategoria implements RepositorioCategoria {

	private final ICategoriaRepository repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public IRepositorioCategoria(ICategoriaRepository repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crearCategoria(Categoria categoria) {
		CategoriaEntity categoriaEntity = modelMapper.map(categoria, CategoriaEntity.class);
		if(!existeCategoria(categoria)) {
		repositorioJpa.save(categoriaEntity);
		}
	}

	@Override
	public boolean existeCategoria(Categoria categoria) {
		CategoriaEntity catAux;
		CategoriaEntity categoriaEntity = modelMapper.map(categoria, CategoriaEntity.class);
		catAux= repositorioJpa.findByNombre(categoriaEntity.getNombre());
		return catAux != null ? true : false;
	}

}
