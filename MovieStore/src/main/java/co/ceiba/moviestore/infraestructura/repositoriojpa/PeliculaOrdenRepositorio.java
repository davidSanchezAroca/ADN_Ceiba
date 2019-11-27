package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import co.ceiba.moviestore.infraestructura.entidades.PeliculaOrdenEntidad;

@Repository
public interface PeliculaOrdenRepositorio extends JpaRepository<PeliculaOrdenEntidad,Integer> {

	@Query(value = "insert into pelicula_orden_entidad (id_pelicula,numero_orden) values (?1,?2)",nativeQuery = true)
	@Modifying
	void saveOrden(int idPelicula, int idOrden);
	
	@Query(value = "delete from pelicula_orden_entidad where id_pelicula = ?1 and numero_orden = ?2 ",nativeQuery = true)
	@Modifying
	void deletePelicula(int idPelicula, int idOrden);
}
