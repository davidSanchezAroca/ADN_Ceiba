package co.ceiba.moviestore.dominio.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManejadorFecha {

	
	public String getDiaSemana(Date fechaActual) {
		String valorDia = null;
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaActual);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		
		if (diaSemana == 1) {
			valorDia = "Domingo";
		} else if (diaSemana == 2) {
			valorDia = "Lunes";
		} else if (diaSemana == 3) {
			valorDia = "Martes";
		} else if (diaSemana == 4) {
			valorDia = "Miercoles";
		} else if (diaSemana == 5) {
			valorDia = "Jueves";
		} else if (diaSemana == 6) {
			valorDia = "Viernes";
		} else if (diaSemana == 7) {
			valorDia = "Sabado";
		}
		return valorDia;
	}
	
	public  Date sumarDiasAFecha(Date fecha, int dias){
	      if (dias==0)
	    	  return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
}
