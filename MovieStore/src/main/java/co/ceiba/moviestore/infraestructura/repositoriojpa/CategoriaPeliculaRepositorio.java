package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.CategoriaPeliculaEntidad;

@Repository
public interface CategoriaPeliculaRepositorio  extends JpaRepository<CategoriaPeliculaEntidad, Integer> {

    @Query(value = "Delete from categoria_pelicula_entidad where id_categoria=?1 and id_pelicula=?2 ", nativeQuery = true)
    @Modifying
	void deleteByPeliculaCategoria( int categoria, int pelicula);
    
    @Query(value = "insert into categoria_pelicula_entidad (id_categoria,id_pelicula) values (?1,?2)",nativeQuery = true)
    @Modifying
    void saveEntidad(int categoria,int pelicula);
}
