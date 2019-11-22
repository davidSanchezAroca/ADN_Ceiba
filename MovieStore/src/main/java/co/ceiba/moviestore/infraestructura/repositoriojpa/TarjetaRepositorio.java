package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.TarjetaCreditoEntidad;

@Repository
public interface TarjetaRepositorio extends JpaRepository<TarjetaCreditoEntidad, Integer> {

    @Query(value= "Select u from TarjetaCreditoEntidad u where u.cliente.cedula=:cedula" )
	List<TarjetaCreditoEntidad> findByCedula(@Param("cedula") String numero);
	
	@Modifying
	@Query(value="Delete from tarjeta_credito_entidad t where t.numero_cuenta= ?1 and t.cedula= ?2",nativeQuery = true)
	void deleteByNumeroCuenta( String numero, String cedula);
	
	List<TarjetaCreditoEntidad> findByNumeroCuenta(String numero);
}
