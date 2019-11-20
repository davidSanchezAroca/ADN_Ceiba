package co.ceiba.moviestore.dominio.repositorio;

import co.ceiba.moviestore.dominio.modelo.Sesion;

public interface RepositorioSesion {

	/**
	 * Permite crear el inicio de sesion
	 * @param sesion
	 */
	void crear(Sesion sesion);
	
	/**
	 * Permite actualizar el inicio de sesion
	 * @param actualizar
	 */
	void actualizar(Sesion actualizar);

}
