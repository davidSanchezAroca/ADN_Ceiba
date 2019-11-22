package co.ceiba.moviestore.dominio.modelo;

import java.util.Date;

public class Orden {

	private int numeroOrden;
	
	private Date fechaOrden;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private double valor;
	
	private Cliente cliente;

	public Orden(int numeroOrden, Date fechaOrden, Date fechaInicio, Date fechaFin, double valor, Cliente cliente) {
		this.numeroOrden = numeroOrden;
		this.fechaOrden = fechaOrden;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valor = valor;
		this.cliente = cliente;
	}

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
