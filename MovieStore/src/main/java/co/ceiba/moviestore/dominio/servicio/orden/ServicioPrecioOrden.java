package co.ceiba.moviestore.dominio.servicio.orden;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoPelicula;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioPelicula;
import co.ceiba.moviestore.dominio.utils.ManejadorFecha;

public class ServicioPrecioOrden {

	private final RepositorioOrden repositorioOrden;
	
	private final RepositorioPelicula repositorioPelicula;
	
	private final ManejadorFecha manejadorfecha;
	
		
	public ServicioPrecioOrden(RepositorioOrden repositorioOrden, 
							   RepositorioPelicula repositorioPelicula) {
		this.repositorioOrden = repositorioOrden;
		this.repositorioPelicula = repositorioPelicula;
		manejadorfecha = new ManejadorFecha();
	}

	public void precio(Orden orden) {
		List<ComandoPelicula> peliculas = repositorioPelicula.listarPeliculas(orden);
		double precio=0;
		if(!peliculas.isEmpty()) {
			for(int i = 0; i < peliculas.size(); i++) {
				precio+= peliculas.get(i).getValor();
			}			
			if(peliculas.size() >= 5) {
				precio = precio*0.8;
			}					
		}
		
		if("Domingo".equals(manejadorfecha.getDiaSemana(orden.getFechaFin()))) {
			precio= precio*2;
		}
		orden.setValor(precio);
		repositorioOrden.actualizar(orden);
	}
}
