package co.ceiba.moviestore.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Column;
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
public class PeliculaOrdenEntity implements Serializable {

	/**
	 * Atributos de la entidad Pelicula_x_Orden
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idPelicula", insertable = false, updatable = false)
	private PeliculaEntity idPelicula;
	
	@ManyToOne
	@JoinColumn(name = "numeroOrden", insertable = false, updatable = false)
	private OrdenEntity numeroOrden;
	
	@Column(name = "cantidad")
	private Integer cantidad;

	public PeliculaOrdenEntity() {
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
	public PeliculaEntity getIdPelicula() {
		return idPelicula;
	}

	/**
	 * @param idPelicula Variable que modifica a  idPelicula 
	 */
	public void setIdPelicula(PeliculaEntity idPelicula) {
		this.idPelicula = idPelicula;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public OrdenEntity getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden Variable que modifica a  numeroOrden 
	 */
	public void setNumeroOrden(OrdenEntity numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad Variable que modifica a  cantidad 
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
