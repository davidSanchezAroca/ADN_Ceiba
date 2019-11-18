package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.CategoriaEntity;

@Repository
public interface ICategoriaRepository  extends JpaRepository<CategoriaEntity, Integer>{

	CategoriaEntity findByNombre(String nombre);
	
}
