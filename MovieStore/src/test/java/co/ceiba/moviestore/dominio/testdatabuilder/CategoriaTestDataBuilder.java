package co.ceiba.moviestore.dominio.testdatabuilder;

import co.ceiba.moviestore.dominio.modelo.Categoria;

public class CategoriaTestDataBuilder {

	private Integer idCategoria;
	
	private String nombre;
	
	public CategoriaTestDataBuilder() {
		this.idCategoria=1;
		this.nombre="terror";
	}

	/**
	 * @return Metodo que obtiene el valor de la variable idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria variable que modifica el valor  idCategoria 
	 */
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre variable que modifica el valor  nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria build() {
		return new Categoria(idCategoria,nombre);
	}
	
	
}
