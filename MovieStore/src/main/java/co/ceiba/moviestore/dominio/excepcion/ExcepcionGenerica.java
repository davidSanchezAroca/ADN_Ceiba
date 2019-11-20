package co.ceiba.moviestore.dominio.excepcion;

public class ExcepcionGenerica extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionGenerica(String msj) {
		super(msj);
	}
	
}
