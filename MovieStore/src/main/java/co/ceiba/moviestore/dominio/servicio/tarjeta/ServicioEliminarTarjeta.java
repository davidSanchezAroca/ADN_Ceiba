package co.ceiba.moviestore.dominio.servicio.tarjeta;

import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;

public class ServicioEliminarTarjeta {

	private RepositorioTarjeta repositorioTarjeta;

	public ServicioEliminarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	public void eliminar(Tarjeta tarjeta) {
		validarExistenciaPrevia(tarjeta);
		this.repositorioTarjeta.eliminar(tarjeta);
	}
	
	public void validarExistenciaPrevia(Tarjeta tarjeta) {
		
	}
	
}
