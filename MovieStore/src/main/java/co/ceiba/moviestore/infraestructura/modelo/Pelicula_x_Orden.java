package co.ceiba.moviestore.infraestructura.modelo;

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
public class Pelicula_x_Orden implements Serializable {

	/**
	 * Atributos de la entidad Pelicula_x_Orden
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idPelicula", insertable = false, updatable = false)
	private Pelicula idPelicula;
	
	@ManyToOne
	@JoinColumn(name = "numeroOrden", insertable = false, updatable = false)
	private Orden numeroOrden;
	
	@Column(name = "cantidad")
	private Integer cantidad;

	public Pelicula_x_Orden() {
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
	public Pelicula getIdPelicula() {
		return idPelicula;
	}

	/**
	 * @param idPelicula Variable que modifica a  idPelicula 
	 */
	public void setIdPelicula(Pelicula idPelicula) {
		this.idPelicula = idPelicula;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public Orden getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden Variable que modifica a  numeroOrden 
	 */
	public void setNumeroOrden(Orden numeroOrden) {
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
