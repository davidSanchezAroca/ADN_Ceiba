package co.ceiba.moviestore.dominio.utils;

import co.ceiba.moviestore.dominio.excepcion.ExcepcionGenerica;
import co.ceiba.moviestore.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

	private ValidadorArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null || "".equals(valor)) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionGenerica(mensaje);
        }
    }
    
    public static void validarNumero(double valor, String mensaje) {
    	if(valor==0) {
    		throw new ExcepcionValorObligatorio(mensaje);
    	}
    }
}
