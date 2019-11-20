package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.modelo.Cliente;

public interface RepositorioCliente {

	/**
	 * Permite realizar creacion de cliente 
	 * @param cliente cliente 
	 */
	void crear(Cliente cliente);
	
	/**
	 * Permite buscar a un cliente por cedula 
	 * @param cedula representa el id del cliente 
	 * @return cliente 
	 */
	ComandoCliente buscar(String cedula);
	
	/**
	 * Pemrite validar si un cliente existe
	 * @param cedula cedula
	 * @return true si exite, false caso contrario 
	 */
	boolean existe(String cedula);
	
	/**
	 * Permite eliminar un cliente
	 * @param cedula del cliente
	 */
	void eliminar(String cedula);
	
	/**
	 * permite actualizar un cliente 
	 * @param cliente cliente 
	 */
	void actualizar(Cliente cliente);
	
	/**
	 * Permite listar todos los clientes
	 * @return clientes
	 */
	List<ComandoCliente> listar();
}
