package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.OrdenEntidad;

@Repository
public interface OrdenRepositorio  extends JpaRepository<OrdenEntidad,Integer>{

	List<OrdenEntidad> findByNumeroOrden(int numero);
}
