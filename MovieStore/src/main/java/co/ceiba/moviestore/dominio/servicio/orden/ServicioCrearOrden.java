package co.ceiba.moviestore.dominio.servicio.orden;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.utils.ManejadorFecha;

public class ServicioCrearOrden {

	private final RepositorioOrden repositorioOrden;
	
	private static final String DIAS_NO_DISPONIBLE = "No se permite prestar peliculas";
	
	private final ManejadorFecha manejadorfecha;

	public ServicioCrearOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
		manejadorfecha= new ManejadorFecha();
	}
	
	public void crear(Orden orden) {
		validarEntregaDomingo(orden);
		validarLunesMartes(orden);
		this.repositorioOrden.crear(orden);
	}
	
	private void validarEntregaDomingo(Orden orden) {
	  if(manejadorfecha.getDiaSemana(orden.getFechaFin()).equals("Domingo")) {
		  orden.setFechaFin(manejadorfecha.sumarDiasAFecha(orden.getFechaFin(),1));
	  }
	}
	
	private void validarLunesMartes(Orden orden) {
		if(manejadorfecha.getDiaSemana(orden.getFechaOrden()).equals("Lunes") || 
				manejadorfecha.getDiaSemana(orden.getFechaOrden()).equals("Martes")) {
			throw new ExcepcionGenerica(DIAS_NO_DISPONIBLE);
		}
	}
}
