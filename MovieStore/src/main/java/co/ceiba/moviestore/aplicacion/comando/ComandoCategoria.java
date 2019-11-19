package co.ceiba.moviestore.aplicacion.comando;

public class ComandoCategoria {
	
	
	private String nombre;
	
	
	
	public ComandoCategoria( String nombre) {
		this.nombre = nombre;
	}

	public ComandoCategoria() {
		super();
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
