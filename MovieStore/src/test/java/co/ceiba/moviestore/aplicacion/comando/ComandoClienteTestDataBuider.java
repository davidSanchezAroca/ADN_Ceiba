package co.ceiba.moviestore.aplicacion.comando;

import java.util.Date;

public class ComandoClienteTestDataBuider {

	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaNacimiento;
	
	public ComandoClienteTestDataBuider() {
		cedula="123";
		nombre="juan";
		apellido="sanchez";
		fechaNacimiento= new Date();
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

	public ComandoCliente build() {
		return new ComandoCliente(cedula, nombre, apellido, fechaNacimiento);
	}
}
