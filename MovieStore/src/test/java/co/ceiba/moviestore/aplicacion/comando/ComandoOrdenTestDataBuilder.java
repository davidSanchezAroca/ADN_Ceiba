package co.ceiba.moviestore.aplicacion.comando;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.ceiba.moviestore.dominio.modelo.Cliente;

public class ComandoOrdenTestDataBuilder {

	private int numeroOrden;
	
	private Date fechaOrden;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private double valor;
	
	private Cliente cliente;
	
	public ComandoOrdenTestDataBuilder() throws ParseException {
		numeroOrden = 123456789;		
		fechaOrden = new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-01");
		fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-01");
		fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-02");
		valor=0.0;
		cliente = new Cliente();
		cliente.setCedula("123");
	}

	/**
	 * @return Metodo que obtiene el valor de la variable numeroOrden
	 */
	public int getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden variable que modifica el valor  numeroOrden 
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
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente variable que modifica el valor  cliente 
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ComandoOrden build() {
		return new ComandoOrden(numeroOrden, fechaOrden, fechaInicio, fechaFin, valor, cliente);
	}
}
