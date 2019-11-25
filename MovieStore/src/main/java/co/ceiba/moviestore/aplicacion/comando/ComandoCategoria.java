package co.ceiba.moviestore.aplicacion.comando;

public class ComandoCategoria {

	private String nombre;
	
	private int idCategoria;
	
	public ComandoCategoria(int idCategoria, String nombre) {
		this.nombre = nombre;
		this.idCategoria=idCategoria;
	}

	public ComandoCategoria() {}
	

	/**
	 * @return Metodo que obtiene el valor de la variable idCategoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria variable que modifica el valor  idCategoria 
	 */
	public void setIdCategoria(int idCategoria) {
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
	
	
}
