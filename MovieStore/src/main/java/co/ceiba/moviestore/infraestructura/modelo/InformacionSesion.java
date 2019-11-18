package co.ceiba.moviestore.infraestructura.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Clase que representa la entidad informacion de sesion
 * @author david.sanchez
 *
 */
@Entity
public class InformacionSesion implements Serializable{
	
	/**
	 * Atributos de la entidad informacionSesion
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "usuario")
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne
	@JoinColumn(name="cedula",insertable = false,updatable = false)
	private Cliente cliente;

	public InformacionSesion() {
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
	 * @return Metodo que obtiene el valor de la variable usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario variable que modifica el valor  usuario 
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password variable que modifica el valor  password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente variable que modifica el valor  cliente 
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
