package co.ceiba.moviestore.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoria;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCategoriaPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPeliculaOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioSesion;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioConsultarCategorias;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioCrearCategoria;
import co.ceiba.moviestore.dominio.servicio.categoria.ServicioEliminarCategoria;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioAsociarCategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioEliminarCategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.categoria.pelicula.ServicioListarCategoriaPelicula;
import co.ceiba.moviestore.dominio.servicio.cliente.ServicioCrearCliente;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioActualizarOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioBuscarOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioCrearOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioListarOrden;
import co.ceiba.moviestore.dominio.servicio.orden.ServicioPrecioOrden;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioActualizarPelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioCrearPelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioEliminarPelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.ServicioListarPelicula;
import co.ceiba.moviestore.dominio.servicio.pelicula.orden.ServicioActualizarPeliculaOrden;
import co.ceiba.moviestore.dominio.servicio.pelicula.orden.ServicioCrearPeliculaOrden;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioActualizarSesion;
import co.ceiba.moviestore.dominio.servicio.sesion.ServicioCrearSesion;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioBuscarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioCrearTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioEliminarTarjeta;
import co.ceiba.moviestore.dominio.servicio.tarjeta.ServicioListarTarjeta;


@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioEliminarCategoria servicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioEliminarCategoria(repositorioCategoria);
	}
	@Bean
	public ServicioConsultarCategorias servicioConsultarCategorias(RepositorioCategoria repositorioCategoria) {
		return new ServicioConsultarCategorias(repositorioCategoria);
	}
	@Bean
	public ServicioCrearCategoria servicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
		return new ServicioCrearCategoria(repositorioCategoria);
	}
	
	/*********************************************
	 * Servicios cliente
	 *********************************************/
	
	
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
	
	@Bean
	public ServicioEliminarPelicula servicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
		return new ServicioEliminarPelicula(repositorioPelicula);
	}
	
	@Bean
	public ServicioListarPelicula servicioListarPelicula(RepositorioPelicula repositorioPelicula) {
		return new ServicioListarPelicula(repositorioPelicula);
	}
	
	@Bean
	public ServicioActualizarPelicula servicioActualizarPelicula(RepositorioPelicula repositorioPelicula) {
		return new ServicioActualizarPelicula(repositorioPelicula);
	}
	
	/*******************************************************
	 *  Servicio orden
	 *******************************************************/
	@Bean
	public ServicioCrearOrden servicioCrearOrden(RepositorioOrden repositorioOrden) {
		return new ServicioCrearOrden(repositorioOrden);
	}
	
	@Bean
	public ServicioActualizarOrden servicioActualizarOrden(RepositorioOrden repositorioOrden) {
		return new ServicioActualizarOrden(repositorioOrden);
	}
	
	@Bean
	public ServicioListarOrden servicioListarOrden(RepositorioOrden repositorioOrden) {
		return new ServicioListarOrden(repositorioOrden);
	}
	
	@Bean
	public ServicioBuscarOrden servicioBuscarOrden(RepositorioOrden repositorioOrden) {
		return new ServicioBuscarOrden(repositorioOrden);
	}
	
	@Bean
	public ServicioPrecioOrden servicioPrecioOrden(RepositorioOrden repositorioOrden,
			RepositorioPelicula repositorioPelicula) {
		return new ServicioPrecioOrden(repositorioOrden,repositorioPelicula);
	}
	
	/********************************************************
	 *  Servicios categoria pelicula
	 ********************************************************/
	@Bean
	public ServicioAsociarCategoriaPelicula servicioAsociarCategoriaPelicula(RepositorioCategoriaPelicula repositorioCategoriaPelicula,
			RepositorioCategoria repositorioCategoria,
			RepositorioPelicula repositorioPelicula) {
		return new ServicioAsociarCategoriaPelicula(repositorioCategoriaPelicula,repositorioCategoria,repositorioPelicula);
	}
	
	
	@Bean
	public ServicioEliminarCategoriaPelicula servicioEliminarCategoriaPelicula(RepositorioCategoriaPelicula repositorioCategoriaPelicula,
			RepositorioPelicula repositorioPelicula,
			RepositorioCategoria repositorioCategoria) {
		return new ServicioEliminarCategoriaPelicula(repositorioCategoriaPelicula,repositorioPelicula,repositorioCategoria);
	}
	
	@Bean
	public ServicioListarCategoriaPelicula servicioListarCategoriaPelicula(RepositorioCategoriaPelicula repositorioCategoriaPelicula) {
		return new ServicioListarCategoriaPelicula(repositorioCategoriaPelicula);
	}
	
	/**********************************************************
	 *  Servicio pelicula orden
	 **********************************************************/
	
	@Bean
	public ServicioCrearPeliculaOrden servicioCrearPeliculaOrden(RepositorioPeliculaOrden repositorioPeliculaOrden,
			RepositorioPelicula repositorioPelicula, RepositorioOrden repositorioOrden) {
		return new ServicioCrearPeliculaOrden(repositorioPeliculaOrden, repositorioPelicula, repositorioOrden);
	}
	
	@Bean
	public ServicioActualizarPeliculaOrden servicioActualizarPeliculaOrden(RepositorioPeliculaOrden repositorioPeliculaOrden,
			RepositorioPelicula repositorioPelicula, RepositorioOrden repositorioOrden) {
		return new ServicioActualizarPeliculaOrden(repositorioPeliculaOrden, repositorioPelicula, repositorioOrden);
	}
	
}
