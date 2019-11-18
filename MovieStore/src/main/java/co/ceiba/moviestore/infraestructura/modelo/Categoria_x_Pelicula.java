package co.ceiba.moviestore.infraestructura.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que representa la entidad intermedia entre categoria y pelicula
 * @author juan-david
 *
 */
@Entity
public class Categoria_x_Pelicula implements Serializable{

	/**
	 * Atributos de la entidad Categoria_x_Pelicula
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="idCategoria",insertable = false,updatable = false)
	private Categoria idCategoria;
	
	@ManyToOne
	@JoinColumn(name = "idPelicula", insertable = false,updatable = false)
	private Pelicula idPelicula;

	
	public Categoria_x_Pelicula() {
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
	 * @return Metodo que obtiene el valor de la variable idCategoria
	 */
	public Categoria getIdCategoria() {
		return idCategoria;
	}


	/**
	 * @param idCategoria Variable que modifica a  idCategoria 
	 */
	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
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
	
	
}
