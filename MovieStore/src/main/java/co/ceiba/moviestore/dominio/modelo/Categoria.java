package co.ceiba.moviestore.dominio.modelo;

/**
 * Clase de dominio que representa categoria 
 * @author david.sanchez
 *
 */
public class Categoria {
	/**
	 * Atributos de la clase categoria 
	 */
	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre es un dato obligatorio.";
	
	private String nombre;

	
	/**
	 * Constructor de la clase categoria
	 * @param nombre
	 */
	public Categoria( String nombre) {
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);		
		this.nombre = nombre;
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
