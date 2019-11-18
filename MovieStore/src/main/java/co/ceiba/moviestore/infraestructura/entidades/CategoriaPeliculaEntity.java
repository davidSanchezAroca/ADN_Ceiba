package co.ceiba.moviestore.infraestructura.entidades;

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
public class CategoriaPeliculaEntity implements Serializable{

	/**
	 * Atributos de la entidad Categoria_x_Pelicula
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="idCategoria",insertable = false,updatable = false)
	private CategoriaEntity idCategoria;
	
	@ManyToOne
	@JoinColumn(name = "idPelicula", insertable = false,updatable = false)
	private PeliculaEntity idPelicula;

	
	public CategoriaPeliculaEntity() {
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
	public CategoriaEntity getIdCategoria() {
		return idCategoria;
	}


	/**
	 * @param idCategoria Variable que modifica a  idCategoria 
	 */
	public void setIdCategoria(CategoriaEntity idCategoria) {
		this.idCategoria = idCategoria;
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
	
	
}
