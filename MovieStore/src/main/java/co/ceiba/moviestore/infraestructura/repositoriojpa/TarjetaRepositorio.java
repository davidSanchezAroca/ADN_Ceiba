package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.TarjetaCreditoEntidad;

@Repository
public interface TarjetaRepositorio extends JpaRepository<TarjetaCreditoEntidad, Integer> {

}
