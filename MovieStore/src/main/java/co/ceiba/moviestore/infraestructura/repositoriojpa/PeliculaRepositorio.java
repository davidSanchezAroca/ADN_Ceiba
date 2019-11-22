package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaEntidad;

public interface PeliculaRepositorio extends JpaRepository<PeliculaEntidad,Integer>{

	Long deleteByNombre(String nombre);
	
	List<PeliculaEntidad> findByNombre(String nombre);
	
}
