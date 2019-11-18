package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.modelo.Categoria;

@Repository
public interface ICategoriaRepository  extends JpaRepository<Categoria, Integer>{

	Categoria findByNombre(String nombre);
	
}
