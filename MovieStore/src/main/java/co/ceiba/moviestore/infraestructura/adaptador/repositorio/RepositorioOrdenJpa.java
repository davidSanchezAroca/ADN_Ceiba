package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.ceiba.moviestore.aplicacion.comando.ComandoOrden;
import co.ceiba.moviestore.dominio.modelo.Orden;
import co.ceiba.moviestore.dominio.repositorio.RepositorioOrden;
import co.ceiba.moviestore.infraestructura.entidades.OrdenEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.OrdenRepositorio;

@Repository
public class RepositorioOrdenJpa implements RepositorioOrden{

	@Autowired
	private final OrdenRepositorio repositorioJpa;
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioOrdenJpa(OrdenRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(Orden orden) {
		OrdenEntidad ordenEntidad= modelMapper.map(orden, OrdenEntidad.class);
		repositorioJpa.save(ordenEntidad);
	}

	@Override
	public void actualizar(Orden orden) {
		OrdenEntidad ordenEnti= modelMapper.map(orden, OrdenEntidad.class);
		repositorioJpa.save(ordenEnti);
	}

	@Override
	public List<ComandoOrden> listar(String cedula) {
		List<ComandoOrden> lista= new ArrayList<>();
		List<OrdenEntidad> listaOrden= repositorioJpa.findAllCedula(cedula);
		for(int i =0 ; i < listaOrden.size(); i++) {
			lista.add(modelMapper.map(listaOrden.get(0),ComandoOrden.class));
		}
		return lista;
	}

	@Override
	public ComandoOrden buscarCliente(Orden orden) {
		List<OrdenEntidad> list=repositorioJpa.findByNumeroOrden(orden.getNumeroOrden(),orden.getCliente().getCedula());
		if(list.size() > 0) {
			return modelMapper.map(list.get(0),ComandoOrden.class);
		}
		return null;
	}

	@Override
	public ComandoOrden buscar(int numero) {
		List<OrdenEntidad> ordenEntidad=repositorioJpa.findByNumero(numero);
		if(ordenEntidad.size() > 0) {
			return modelMapper.map(ordenEntidad.get(0),ComandoOrden.class);
		}
		return null;
	}

	
	
	

}
