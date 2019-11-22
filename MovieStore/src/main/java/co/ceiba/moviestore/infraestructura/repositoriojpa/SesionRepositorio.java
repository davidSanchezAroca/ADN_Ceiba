package co.ceiba.moviestore.infraestructura.repositoriojpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ceiba.moviestore.infraestructura.entidades.InformacionSesionEntidad;

public interface SesionRepositorio extends JpaRepository<InformacionSesionEntidad, Integer> {
}
