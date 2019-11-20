package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaEntidad;

public interface PeliculaRepositorio extends JpaRepository<PeliculaEntidad,Integer>{

}
