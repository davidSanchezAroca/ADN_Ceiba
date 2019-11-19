package co.ceiba.moviestore.infraestructura.repositoriojpa;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.ceiba.moviestore.infraestructura.entidades.CategoriaEntidad;

@Repository
public interface CategoriaRepositorio  extends JpaRepository<CategoriaEntidad, Integer>{

	List<CategoriaEntidad> findByNombre(String nombre);
	
	Long deleteByNombre(String nombre);
}
