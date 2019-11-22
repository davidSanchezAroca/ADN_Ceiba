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
	
	private int idCategoria;
	
	private String nombre;

	
	/**
	 * Constructor de la clase categoria
	 * @param nombre
	 */
	public Categoria(int idCategoria, String nombre) {
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);		
		this.nombre = nombre;
		this.idCategoria=idCategoria;
	}
	
	public Categoria() {}

	

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
