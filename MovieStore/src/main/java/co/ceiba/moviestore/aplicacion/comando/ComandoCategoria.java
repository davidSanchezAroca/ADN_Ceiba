package co.ceiba.moviestore.aplicacion.comando;




public class ComandoCategoria {
	
	private Integer idCategoria;
	
	private String nombre;
	
	
	
	public ComandoCategoria(Integer idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public ComandoCategoria() {
		super();
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
	
	
}
