package co.ceiba.moviestore.aplicacion.comando;

public class ComandoCategoriaTestDataBuilder {

	private String nombre;
	
	private int idCategoria;
	
	public ComandoCategoriaTestDataBuilder() {	
		this.idCategoria=1;
		this.nombre="terror";
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
	
	public ComandoCategoria build() {
		return new ComandoCategoria(idCategoria,nombre);
	}
	
}
