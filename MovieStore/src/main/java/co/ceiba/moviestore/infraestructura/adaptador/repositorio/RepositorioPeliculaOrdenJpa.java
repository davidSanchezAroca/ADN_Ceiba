package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.aplicacion.comando.ComandoPeliculaOrden;
import co.ceiba.moviestore.dominio.modelo.PeliculaOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPeliculaOrden;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaOrdenEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.PeliculaOrdenRepositorio;

@Repository
public class RepositorioPeliculaOrdenJpa implements RepositorioPeliculaOrden{

	@Autowired
	private final PeliculaOrdenRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioPeliculaOrdenJpa(PeliculaOrdenRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(int idPelicula, int idOrden) {
		this.repositorioJpa.saveOrden(idPelicula,idOrden);
	}

	@Override
	public void actualizar(PeliculaOrden comandoPeliculaOrden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ComandoPeliculaOrden> comandoPeliculaOrden() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
