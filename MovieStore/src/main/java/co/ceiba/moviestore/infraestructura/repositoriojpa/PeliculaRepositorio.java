package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaEntidad;

public interface PeliculaRepositorio extends JpaRepository<PeliculaEntidad,Integer>{

	Long deleteByNombre(String nombre);
	
	List<PeliculaEntidad> findByNombre(String nombre);
	

	
	@Query(value = "select p.id_pelicula,p.nombre, p.valor from  \n" + 
			"(select * from orden_entidad o \n" + 
			"		inner join pelicula_orden_entidad poii \n" + 
			"		on o.numero_orden=poii.numero_orden \n" + 
			"	  where o.cedula=?1 and o.numero_orden=?2 ) as x2\n" + 
			"inner join \n" + 
			"	pelicula_entidad as p on p.id_pelicula = x2.id_pelicula" , nativeQuery = true)
	@Modifying
    List<PeliculaEntidad> findPelicula(String cedula, int numero);
	
}
