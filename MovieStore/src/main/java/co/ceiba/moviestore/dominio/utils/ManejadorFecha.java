package co.ceiba.moviestore.dominio.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManejadorFecha {

	
	public String getDiaSemana(Date fechaActual) {
		String Valor_dia = null;
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaActual);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		
		if (diaSemana == 1) {
			Valor_dia = "Domingo";
		} else if (diaSemana == 2) {
			Valor_dia = "Lunes";
		} else if (diaSemana == 3) {
			Valor_dia = "Martes";
		} else if (diaSemana == 4) {
			Valor_dia = "Miercoles";
		} else if (diaSemana == 5) {
			Valor_dia = "Jueves";
		} else if (diaSemana == 6) {
			Valor_dia = "Viernes";
		} else if (diaSemana == 7) {
			Valor_dia = "Sabado";
		}
		return Valor_dia;
	}
	
	public  Date sumarDiasAFecha(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
}
