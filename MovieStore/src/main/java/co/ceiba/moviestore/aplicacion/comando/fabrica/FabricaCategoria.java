package co.ceiba.moviestore.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.ceiba.moviestore.aplicacion.comando.ComandoCategoria;
import co.ceiba.moviestore.dominio.modelo.Categoria;

@Component
public class FabricaCategoria {

	public Categoria crearCategoria(ComandoCategoria comandoCategoria) {
		return new Categoria(comandoCategoria.getIdCategoria(), comandoCategoria.getNombre());
	}
}
