package co.ceiba.moviestore.dominio.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * Clase que representa la entidad cliente
 * @author david.sanchez
 *
 */
@Entity
public class Cliente implements Serializable {

	/**
	 * Atributos de la entidad cliente 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column( name= "apellido")
	private String apellido;
	
	@Column ( name= "fechaNacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="sesion_id", referencedColumnName = "id")
	private InformacionSesion sesion;

	public Cliente() {
		super();
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula variable que modifica el valor  cedula 
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	 * @return Metodo que obtiene el valor de la variable apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido variable que modifica el valor  apellido 
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento variable que modifica el valor  fechaNacimiento 
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable sesion
	 */
	public InformacionSesion getSesion() {
		return sesion;
	}

	/**
	 * @param sesion variable que modifica el valor  sesion 
	 */
	public void setSesion(InformacionSesion sesion) {
		this.sesion = sesion;
	}
	
	
	
}
