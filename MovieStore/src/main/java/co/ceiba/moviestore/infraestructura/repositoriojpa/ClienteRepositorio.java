package co.ceiba.moviestore.infraestructura.repositoriojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import co.ceiba.moviestore.infraestructura.entidades.ClienteEntidad;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteEntidad, String>{

	List<ClienteEntidad> findByCedula(String cedula); 
	
	Long deleteByCedula(String cedula);
}
