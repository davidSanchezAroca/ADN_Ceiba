package co.ceiba.moviestore.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioConsultarCategorias;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioCrearCliente;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioCrearPelicula;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioActualizarSesion;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioCrearSesion;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioBuscarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioCrearTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioEliminarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioListarTarjeta;


@Configuration
public class BeanServicio {
	
	
	/*********************************************
	 * Servicios cliente
	 *********************************************/
	
	public ServicioConsultarCategorias servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioConsultarCategorias(repositorioCategoria);
	}
	
	public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}
	
	/*********************************************
	 * Servicios Tarjeta
	 *********************************************/
	
	@Bean
	public ServicioCrearTarjeta servicioCrearTarjeta(RepositorioTarjeta repositorioTarjeta) {
		return new ServicioCrearTarjeta(repositorioTarjeta);
	}
	@Bean
	public ServicioEliminarTarjeta servicioEliminarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		return new ServicioEliminarTarjeta(repositorioTarjeta);
	}
	@Bean
	public ServicioListarTarjeta servicioListarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		return new ServicioListarTarjeta(repositorioTarjeta);
	}
	
	@Bean
	public ServicioBuscarTarjeta servicioBuscarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		return new ServicioBuscarTarjeta(repositorioTarjeta);
	}
	/*********************************************
	 * Servicios sesion
	 *********************************************/
	@Bean
	public ServicioCrearSesion servicioCrearSesion(RepositorioSesion repositorioSesion) {
		return new ServicioCrearSesion(repositorioSesion);
	}
	
	@Bean
	public ServicioActualizarSesion servicioActualizarSesion(RepositorioSesion repositorioSesion) {
		return new ServicioActualizarSesion(repositorioSesion);
	}
	
	/**********************************************
	 *Servicios pelicula 
	 *********************************************/
	@Bean
	public ServicioCrearPelicula servicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
		return new ServicioCrearPelicula(repositorioPelicula);
	}
}
