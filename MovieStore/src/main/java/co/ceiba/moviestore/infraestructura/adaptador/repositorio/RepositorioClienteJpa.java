package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.ceiba.moviestore.aplicacion.comando.ComandoCliente;
import co.ceiba.moviestore.dominio.modelo.Cliente;
import co.ceiba.moviestore.dominio.repositorio.RepositorioCliente;
import co.ceiba.moviestore.infraestructura.entidades.ClienteEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.ClienteRepositorio;

@Repository
public class RepositorioClienteJpa  implements RepositorioCliente{

	@Autowired
	private final ClienteRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	

	public RepositorioClienteJpa(ClienteRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}
	
	@Override
	public void crear(Cliente cliente) {
		ClienteEntidad clienteEntidad= modelMapper.map(cliente, ClienteEntidad.class);
		repositorioJpa.save(clienteEntidad);
	}

	@Override
	public ComandoCliente buscar(String cedula) {
		List<ClienteEntidad> listCliente;
		listCliente= repositorioJpa.findByCedula(cedula);		
		return listCliente.size() == 1 ? modelMapper.map(listCliente.get(0),ComandoCliente.class): null;
	}

	@Override
	public boolean existe(String cedula) {
		List<ClienteEntidad> cliAux;
		cliAux = repositorioJpa.findByCedula(cedula);
		return !cliAux.isEmpty() ;
	}

	@Override
	@Transactional
	public void eliminar(String cedula) {
		repositorioJpa.deleteByCedula(cedula);
	}

	@Override
	public void actualizar(Cliente cliente) {
		ClienteEntidad clienteEnti= modelMapper.map(cliente, ClienteEntidad.class);
		repositorioJpa.save(clienteEnti);
	}

	@Override
	public List<ComandoCliente> listar() {
		List<ClienteEntidad> listaCliente = repositorioJpa.findAll();
		List<ComandoCliente> result= new ArrayList<>();
		for(int i=0; i < listaCliente.size(); i++) {
			result.add(modelMapper.map(listaCliente.get(i), ComandoCliente.class));			
		}
		return result;
	}
	
	
}
