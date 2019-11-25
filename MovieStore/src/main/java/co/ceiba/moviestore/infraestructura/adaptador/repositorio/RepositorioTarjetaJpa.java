package co.ceiba.moviestore.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.ceiba.moviestore.aplicacion.comando.ComandoTarjeta;
import co.ceiba.moviestore.dominio.modelo.Tarjeta;
import co.ceiba.moviestore.dominio.repositorio.RepositorioTarjeta;
import co.ceiba.moviestore.infraestructura.entidades.TarjetaCreditoEntidad;
import co.ceiba.moviestore.infraestructura.repositoriojpa.TarjetaRepositorio;

@Repository
public class RepositorioTarjetaJpa implements RepositorioTarjeta {

	@Autowired
	private final TarjetaRepositorio repositorioJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioTarjetaJpa(TarjetaRepositorio repositorioJpa) {
		this.repositorioJpa = repositorioJpa;
	}

	@Override
	public void crear(Tarjeta tarjeta) {
		TarjetaCreditoEntidad tarjetaEntidad = modelMapper.map(tarjeta,TarjetaCreditoEntidad.class);
		repositorioJpa.save(tarjetaEntidad);
	}

	@Override
	public boolean existe(Tarjeta tarjeta) {
		List<TarjetaCreditoEntidad> tarjAux;
		tarjAux= repositorioJpa.findByNumeroCuenta(tarjeta.getNumeroCuenta(),tarjeta.getCliente().getCedula());
		return !tarjAux.isEmpty();
	}

	@Override
	@Transactional
	public void eliminar(Tarjeta tarjeta) {
		repositorioJpa.deleteByNumeroCuenta(tarjeta.getNumeroCuenta(),tarjeta.getCliente().getCedula());
	}

	@Override
	public ComandoTarjeta buscar(Tarjeta tarjeta) {
		List<TarjetaCreditoEntidad> listTarjeta;
		listTarjeta= repositorioJpa.findByNumeroCuenta(tarjeta.getNumeroCuenta(),tarjeta.getCliente().getCedula());
		return listTarjeta.size() == 1 ? modelMapper.map(listTarjeta.get(0),ComandoTarjeta.class) : null;
	}

	@Override
	public List<ComandoTarjeta> listar(String numero) {
		List<TarjetaCreditoEntidad> listaTarjeta = repositorioJpa.findAll();
		List<ComandoTarjeta> result = new ArrayList<>();
		for(int i=0; i < listaTarjeta.size(); i++) {
			result.add(modelMapper.map(listaTarjeta.get(0),ComandoTarjeta.class));
		}
		return result;
	}

	@Override
	public void actualizar(Tarjeta tarjeta) {
	  TarjetaCreditoEntidad tarjetaEntidad = modelMapper.map(tarjeta,TarjetaCreditoEntidad.class);
	  repositorioJpa.save(tarjetaEntidad);
	}

}
