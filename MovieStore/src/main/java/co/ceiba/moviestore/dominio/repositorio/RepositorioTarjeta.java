package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;

public interface RepositorioTarjeta {

	/**
	 * Permite crear una terjeta en el sistema 
	 * @param tarjeta
	 */
	void crear(Tarjeta tarjeta);
	
	/**
	 * Permite validar la exitencia de una tarjeta
	 */
	boolean existe(Tarjeta tarjeta);
	
	/**
	 * Permite eliminar una tarjeta del sistema 
	 * @param numero numero de la tarjeta 
	 */
	void eliminar(Tarjeta tarjeta);
	
	/**
	 * Permite realizar la busqueda de una tarjeta por numero
	 * @param numero
	 * @return
	 */
	ComandoTarjeta buscar(Tarjeta tarjeta);
	/**
	 * Permite listar las tarejtas guardadas
	 * @param numero
	 * @return
	 */
	List<ComandoTarjeta> listar(String cedula);
	
	/**
	 * Permite realizar la actualizacion de una tarjeta 
	 * @param tarjeta tarjeta 
	 */
	void actualizar(Tarjeta tarjeta);
}
