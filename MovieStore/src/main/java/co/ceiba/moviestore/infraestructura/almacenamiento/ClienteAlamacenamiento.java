package co.ceiba.moviestore.infraestructura.almacenamiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.infraestructura.entidades.ClienteEntidad;

@Repository
public class ClienteAlamacenamiento {

	
	private static List<ClienteEntidad> clientes = new ArrayList<ClienteEntidad>();
	
	public void save(ClienteEntidad cliente) {
		clientes.add(cliente);
	}
	
	public void deleteByCedula(String cedula) {
		
	}
	
	public List<ClienteEntidad> findByCedula(String cedula) {
			return new ArrayList<ClienteEntidad>();	
	}
	
	public List<ClienteEntidad> findAll() {
		return null;
	}
}
