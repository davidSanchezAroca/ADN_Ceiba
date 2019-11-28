package co.ceiba.moviestore.dominio.testdatabuilder;

import java.util.Date;

import co.ceiba.moviestore.dominio.modelo.Cliente;

public class ClienteTestDataBuilder {
	
private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaNacimiento;
	
	public ClienteTestDataBuilder () {
		this.cedula="1234565";
		this.nombre="juan";
		this.apellido="sanchez";
		this.fechaNacimiento = new Date();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Cliente build() {
		return new Cliente(cedula, nombre, apellido, fechaNacimiento);
	}
}
