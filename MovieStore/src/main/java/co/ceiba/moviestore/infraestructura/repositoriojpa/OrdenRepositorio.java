package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.OrdenEntidad;

@Repository
public interface OrdenRepositorio  extends JpaRepository<OrdenEntidad,Integer>{

	@Query(value = "Select u from OrdenEntidad u where u.numeroOrden=:numeroOrden and u.cliente.cedula=:cedula")
	List<OrdenEntidad> findByNumeroOrden(@Param("numeroOrden") int numero, @Param("cedula") String cedula);
	
	@Query(value = "select u from OrdenEntidad u where u.cliente.cedula=:cedula")
	List<OrdenEntidad> findAllCedula(@Param("cedula") String cedula);
	
	@Query(value = "select u from OrdenEntidad u where u.numeroOrden=:numeroOrden")
	List<OrdenEntidad> findByNumero(@Param("numeroOrden")int numero);
}
