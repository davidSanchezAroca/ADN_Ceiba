package co.ceiba.moviestore.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa la entidad 
 * @author david.sanchez
 *
 */
@Entity
public class CategoriaEntidad implements Serializable {

	/**
	 * Atributos de la entidad categoria
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategoria")
	private Integer idCategoria;
	
	@Column(name ="nombre")
	private String nombre;

	public CategoriaEntidad() {
		super();
	}

	

	/**
	 * @return Metodo que obtiene el valor de la variable idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}



	/**
	 * @param idCategoria variable que modifica el valor  idCategoria 
	 */
	public void setIdCategoria(Integer idCategoria) {
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
