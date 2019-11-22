package co.ceiba.moviestore.dominio.repositorio;

import java.util.List;

import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;

public interface RepositorioOrden {
	
	void crear(Orden orden);
	
	void actualizar(Orden orden);
	
	List<ComandoOrden>  listar(String cedula);
	
	ComandoOrden buscarCliente(Orden orden);
	
	ComandoOrden buscar(int numero);
}
