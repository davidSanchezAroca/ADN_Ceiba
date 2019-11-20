package co.ceiba.moviestore.dominio.servicio.tarjeta;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;

public class ServicioBuscarTarjeta {

	private RepositorioTarjeta repositorioTarjeta;
	
	private static final String NO_EXISTE_TARJETA_ASOCIADA="No exite la tarjeta asociada";

	public ServicioBuscarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	public ComandoTarjeta buscar(String numero) {
		ComandoTarjeta comandoTarjeta= repositorioTarjeta.buscar(numero);
		validarExistencia(comandoTarjeta);
		return comandoTarjeta;
	}
	
	public void validarExistencia(ComandoTarjeta comandoTarjeta) {
		if(comandoTarjeta==null) {
			throw new ExcepcionGenerica(NO_EXISTE_TARJETA_ASOCIADA);
		}
	}
	
	
}
