package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.dominio.modelo.Pelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.PeliculaRepositorio;

@Repository
public class RepositorioPeliculaJpa implements RepositorioPelicula {

	@Autowired
	private final PeliculaRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioPeliculaJpa(PeliculaRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(Pelicula pelicula) {
		PeliculaEntidad peliculaEntidad= modelMapper.map(pelicula, PeliculaEntidad.class); 
		repositorioJpa.save(peliculaEntidad);		
	}

}
