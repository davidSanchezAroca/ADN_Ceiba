package co.ceiba.moviestore.dominio.modelo;

import java.util.Date;

import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class Cliente {

	/**
	 * Atributos de la clase cliente
	 */
	
	private static final String LA_CEDULA_ES_OBLIGATORIA= "La cedula es un dato obligatorio";
	private static final String EL_NOMBRE_ES_OBLIGATORIO = "El nombre es un dato obligatorio";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "El apellido es un dato obligatorio";
	private static final String LA_FECHA_ES_OBLIGATORIA = "La fecha es un dato obligatorio";
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaNacimiento;

	/**
	 * Constructor de la clase cliente 
	 * @param cedula
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 */
	public Cliente(String cedula, String nombre, String apellido, Date fechaNacimiento) {
		ValidadorArgumento.validarObligatorio(cedula, LA_CEDULA_ES_OBLIGATORIA);
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(apellido, EL_APELLIDO_ES_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(fechaNacimiento, LA_FECHA_ES_OBLIGATORIA);
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

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
	
	
}
