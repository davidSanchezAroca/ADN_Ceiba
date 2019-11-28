package co.ceiba.moviestore.dominio.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExcepcionDuplicidad extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}
