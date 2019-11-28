package co.ceiba.moviestore.dominio.testdatabuilder;

import co.ceiba.moviestore.dominio.modelo.Pelicula;

public class PeliculaTestDataBuilder {
	
	private int idProducto;
	
	private String nombre;
	
	private double valor;
	
	public PeliculaTestDataBuilder () {
		this.idProducto = 1;
		this.nombre = "Avengers";
		this.valor=100;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Pelicula build() {
		return new Pelicula(idProducto, nombre, valor);
	}

}
