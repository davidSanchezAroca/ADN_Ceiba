package co.ceiba.moviestore.dominio.servicio.tarjeta;



import org.springframework.stereotype.Component;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;

@Component
public class ServicioCrearTarjeta {

	private static final String LA_TARJETA_YA_EXISTE = "La tarjeta ya existe en el sistema";
	
	private final RepositorioTarjeta repositorioTarjeta;

	public ServicioCrearTarjeta(RepositorioTarjeta repositorioTarjeta) {		
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	
	public void crear(Tarjeta tarjeta) {
		validarExistenciaPrevia(tarjeta.getNumeroCuenta());
		this.repositorioTarjeta.crear(tarjeta);
	}
	
	public void validarExistenciaPrevia(String numero) {
		boolean existe = this.repositorioTarjeta.existe(numero);
		if(existe) {
			throw new ExcepcionGenerica(LA_TARJETA_YA_EXISTE);
		}
	}
	
}
