package co.ceiba.moviestore.dominio.servicio.tarjeta;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;

public class ServicioEliminarTarjeta {

	private static final String NO_EXISTE_TARJETA = "No existe tarjeta en el sistema"; 
	private RepositorioTarjeta repositorioTarjeta;

	public ServicioEliminarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	public void eliminar(Tarjeta tarjeta) {
		validarExistenciaPrevia(tarjeta);
		this.repositorioTarjeta.eliminar(tarjeta);
	}
	
	public void validarExistenciaPrevia(Tarjeta tarjeta) {
		 boolean exite= repositorioTarjeta.existe(tarjeta);
		 if(!exite) {
			 throw new ExcepcionGenerica(NO_EXISTE_TARJETA);
		 }
	}
	
}
