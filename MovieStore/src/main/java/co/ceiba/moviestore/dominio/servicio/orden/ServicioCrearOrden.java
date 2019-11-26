package co.ceiba.moviestore.dominio.servicio.orden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.dominio.utils.ManejadorFecha;

public class ServicioCrearOrden {

	private final RepositorioOrden repositorioOrden;
	
	private final ManejadorFecha manejadorfecha;

	public ServicioCrearOrden(RepositorioOrden repositorioOrden) {
		this.repositorioOrden = repositorioOrden;
		manejadorfecha= new ManejadorFecha();
	}
	
	public void crear(Orden orden) {
		validarEntregaDomingo(orden);
		this.repositorioOrden.crear(orden);
	}
	
	private void validarEntregaDomingo(Orden orden) {
	  if(manejadorfecha.getDiaSemana(orden.getFechaFin()).equals("Domingo")) {
		  orden.setFechaInicio(manejadorfecha.generarFechaEntrega(1,orden.getFechaFin()));
	  }
	}
}
