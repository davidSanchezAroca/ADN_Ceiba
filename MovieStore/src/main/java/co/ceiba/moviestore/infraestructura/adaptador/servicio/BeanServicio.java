package co.ceiba.moviestore.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Configuration;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.servicio.ServicioCrearCategoria;


@Configuration
public class BeanServicio {
	public ServicioCrearCategoria servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioCrearCategoria(repositorioCategoria);
	}
}
