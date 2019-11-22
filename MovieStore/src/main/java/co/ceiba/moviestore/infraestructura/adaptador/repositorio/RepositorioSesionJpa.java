package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.dominio.modelo.Sesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;
import co.ceiba.moviestore.infraestructura.entidades.InformacionSesionEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.SesionRepositorio;

@Repository
public class RepositorioSesionJpa implements RepositorioSesion{

	@Autowired
	private final SesionRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
		
	public RepositorioSesionJpa(SesionRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(Sesion sesion) {
		InformacionSesionEntidad sesionEntidad= modelMapper.map(sesion, InformacionSesionEntidad.class);
		System.out.println("---->"+sesionEntidad.getCliente().getCedula());
		repositorioJpa.save(sesionEntidad);
	}

	@Override
	public void actualizar(Sesion sesion) {
		InformacionSesionEntidad sesionEntid = modelMapper.map(sesion,InformacionSesionEntidad.class);
		repositorioJpa.save(sesionEntid);
	}

}
