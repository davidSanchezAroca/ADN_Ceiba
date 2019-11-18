package co.ceiba.moviestore.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa la entidad pelicula
 * @author david.sanchez
 *
 */
@Entity
public class PeliculaEntity implements Serializable{
	
	/**
	 * Atributos de la entidad pelicula
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPelicula")
	private Integer idProducto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name ="valor")
	private double valor;

	public PeliculaEntity() {
		super();
	}

	

	/**
	 * @return Metodo que obtiene el valor de la variable idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}



	/**
	 * @param idProducto variable que modifica el valor  idProducto 
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	/**
	 * @return Metodo que obtiene el valor de la variable valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor variable que modifica el valor  valor 
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	

}
