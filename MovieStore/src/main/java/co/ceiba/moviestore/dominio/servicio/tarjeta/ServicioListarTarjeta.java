package co.ceiba.moviestore.dominio.servicio.tarjeta;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class ServicioListarTarjeta {

	private RepositorioTarjeta repositorioTarjeta;

	public ServicioListarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	public List<ComandoTarjeta> listar(String cedula){
		ValidadorArgumento.validarObligatorio(cedula, Tarjeta.DATOS_INCOMPLETOS_TARJETA);
		return this.repositorioTarjeta.listar(cedula);
	}
}
