package co.ceiba.moviestore.dominio.servicio.tarjeta;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;

public class ServicioListarTarjeta {

	private RepositorioTarjeta repositorioTarjeta;

	public ServicioListarTarjeta(RepositorioTarjeta repositorioTarjeta) {
		this.repositorioTarjeta = repositorioTarjeta;
	}
	
	public List<ComandoTarjeta> listar(String cedula){
		return this.repositorioTarjeta.listar(cedula);
	}
	
	
}
