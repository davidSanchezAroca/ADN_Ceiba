package co.ceiba.moviestore.infraestructura.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que representa la entidad Pelicula_x_Orden
 * @author juan-david
 *
 */
@Entity
public class PeliculaOrdenEntidad implements Serializable {

	/**
	 * Atributos de la entidad Pelicula_x_Orden
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idPelicula", insertable = false, updatable = false)
	private PeliculaEntidad idPelicula;
	
	@ManyToOne
	@JoinColumn(name = "numeroOrden", insertable = false, updatable = false)
	private OrdenEntidad numeroOrden;
	

	public PeliculaOrdenEntidad() {
		super();
	}

	/**
	 * @return Metodo que obtiene el valor de la variable id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Variable que modifica a  id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable idPelicula
	 */
	public PeliculaEntidad getIdPelicula() {
		return idPelicula;
	}

	/**
	 * @param idPelicula Variable que modifica a  idPelicula 
	 */
	public void setIdPelicula(PeliculaEntidad idPelicula) {
		this.idPelicula = idPelicula;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public OrdenEntidad getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden Variable que modifica a  numeroOrden 
	 */
	public void setNumeroOrden(OrdenEntidad numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
		
}
