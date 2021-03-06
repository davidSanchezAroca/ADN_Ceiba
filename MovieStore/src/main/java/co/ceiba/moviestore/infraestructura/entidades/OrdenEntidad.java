package co.ceiba.moviestore.infraestructura.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad orden
 * @author david.sanchez
 *
 */
@Entity
public class OrdenEntidad implements Serializable {

	/**
	 * Atributos de la entidad Orden
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numeroOrden")
	private Integer numeroOrden;
	
	@Column(name="fechaOrden")
	@Temporal(TemporalType.DATE)
	private Date fechaOrden;
	
	@Column(name="fechaInicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Column(name="fechaFin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	@Column(name="valor")
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "cedula", nullable = false)
	private ClienteEntidad cliente;

	public OrdenEntidad() {
		super();
	}



	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public Integer getNumeroOrden() {
		return numeroOrden;
	}



	/**
	 * @param numeroOrden Variable que modifica a  numeroOrden 
	 */
	public void setNumeroOrden(Integer numeroOrden) {
		this.numeroOrden = numeroOrden;
	}



	/**
	 * @return Metodo que obtiene el valor de la variable fechaOrden
	 */
	public Date getFechaOrden() {
		return fechaOrden;
	}

	/**
	 * @param fechaOrden variable que modifica el valor  fechaOrden 
	 */
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio variable que modifica el valor  fechaInicio 
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin variable que modifica el valor  fechaFin 
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

}
