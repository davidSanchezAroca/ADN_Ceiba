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
 * Clase que representa la entidad tarjeta de credito
 * @author david.sanchez
 *
 */
@Entity
public class TarjetaCreditoEntidad implements Serializable{

	/**
	 * Atributos de la entidad tarjeta de credito 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="franquicia")
	private String franquicia;
	
	@Column(name="numeroCuenta")
	private String numeroCuenta;
	
	@ManyToOne
	@JoinColumn(name = "cedula", nullable = false)
	private ClienteEntidad cliente;

	public TarjetaCreditoEntidad() {
		super();
	}

	

	/**
	 * @return Metodo que obtiene el valor de la variable id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id variable que modifica el valor  id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return Metodo que obtiene el valor de la variable franquicia
	 */
	public String getFranquicia() {
		return franquicia;
	}

	/**
	 * @param franquicia variable que modifica el valor  franquicia 
	 */
	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta variable que modifica el valor  numeroCuenta 
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cliente
	 */
	public ClienteEntidad getCliente() {
		return cliente;
	}

	/**
	 * @param cliente variable que modifica el valor  cliente 
	 */
	public void setCliente(ClienteEntidad cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [id=" + id + ", franquicia=" + franquicia + ", numeroCuenta=" + numeroCuenta
				+ ", cliente=" + cliente + "]";
	}	
}
