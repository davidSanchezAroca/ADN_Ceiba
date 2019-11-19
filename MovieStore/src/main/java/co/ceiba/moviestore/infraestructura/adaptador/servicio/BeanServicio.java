package co.ceiba.moviestore.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Configuration;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioConsultarCategorias;


@Configuration
public class BeanServicio {
	public ServicioConsultarCategorias servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioConsultarCategorias(repositorioCategoria);
	}
}
