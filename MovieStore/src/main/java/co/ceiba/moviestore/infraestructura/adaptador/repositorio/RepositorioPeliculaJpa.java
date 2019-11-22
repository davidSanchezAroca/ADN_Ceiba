package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
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
	
	@Override
	@Transactional
	public void eliminar(String nombre) {
		repositorioJpa.deleteByNombre(nombre);
	}

	@Override
	public List<ComandoPelicula> listar() {
		List<ComandoPelicula> listar= new ArrayList<>();
		List<PeliculaEntidad> listaPelicula= repositorioJpa.findAll();
		
		for(int i=0; i < listaPelicula.size();i++) {
			listar.add(modelMapper.map(listaPelicula.get(0), ComandoPelicula.class));
		}
		return listar;
	}

	@Override
	public void actualizar(Pelicula pelicula) {
		PeliculaEntidad peliculaEntidad= modelMapper.map(pelicula, PeliculaEntidad.class);
		repositorioJpa.save(peliculaEntidad);
	}

	@Override
	public ComandoPelicula buscar(String nombre) {
		List<PeliculaEntidad> peliculaEntidad=repositorioJpa.findByNombre(nombre);
		if(peliculaEntidad.size() > 0) {
		return  modelMapper.map(peliculaEntidad.get(0),ComandoPelicula.class);
		}
		return null;
	}

}
