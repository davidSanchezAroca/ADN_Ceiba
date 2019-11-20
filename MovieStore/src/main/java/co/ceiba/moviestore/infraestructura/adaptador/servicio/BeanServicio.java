package co.ceiba.moviestore.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Configuration;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioConsultarCategorias;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioCrearCliente;


@Configuration
public class BeanServicio {
	public ServicioConsultarCategorias servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioConsultarCategorias(repositorioCategoria);
	}
	
	public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}
}
