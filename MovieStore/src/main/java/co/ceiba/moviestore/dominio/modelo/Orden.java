package co.ceiba.moviestore.dominio.modelo;

import java.util.Date;

import co.ceiba.moviestore.dominio.utils.ValidadorArgumento;

public class Orden {

	private static final String FECHA_VALIDA="La fecha no cuenta con un valor asignado";
	private static final String CLIENTE_NO_EXISTE = "No hay informacion del cliente";
	private int numeroOrden;
	
	private Date fechaOrden;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private double valor;
	
	private Cliente cliente;

	public Orden(int numeroOrden, Date fechaOrden, Date fechaInicio, Date fechaFin, double valor, Cliente cliente) {
		ValidadorArgumento.validarObligatorio(fechaOrden,FECHA_VALIDA);
		ValidadorArgumento.validarObligatorio(fechaInicio, FECHA_VALIDA);
		ValidadorArgumento.validarObligatorio(fechaFin, FECHA_VALIDA);
		ValidadorArgumento.validarObligatorio(cliente.getCedula(),CLIENTE_NO_EXISTE);
		this.numeroOrden = numeroOrden;
		this.fechaOrden = fechaOrden;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valor = valor;
		this.cliente = cliente;
	}
	
	public Orden() {}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public int getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden Variable que modifica a  numeroOrden 
	 */
	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable fechaOrden
	 */
	public Date getFechaOrden() {
		return fechaOrden;
	}

	/**
	 * @param fechaOrden Variable que modifica a  fechaOrden 
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
	 * @param fechaInicio Variable que modifica a  fechaInicio 
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
	 * @param fechaFin Variable que modifica a  fechaFin 
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
	 * @param valor Variable que modifica a  valor 
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return Metodo que obtiene el valor de la variable cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente Variable que modifica a  cliente 
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
