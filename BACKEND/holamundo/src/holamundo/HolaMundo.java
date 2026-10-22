package holamundo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Ejemplo de HolaMundo
 */
public class HolaMundo {
	/**
	 * Método de inicio de la aplicación
	 * 
	 * @param args argumentos recibidos por consola
	 */
	public static void main(String[] args) {
		/*
		 * En este método vamos a utilizar diversas técn...
		 */

		// Mostrar por pantalla "Hola"
		System.out.println("Hola");

		int x = 5;

		@SuppressWarnings("unused")
		long l = 21470000000L;

		@SuppressWarnings("unused")
		int y = x;

		double d1 = 0.1;
		double d2 = 0.2;

		double suma = d1 + d2;

		System.out.println(suma);

		String nombre = "Pepe";

		System.out.println("Hola " + nombre);

		System.out.println("""
				Hola a todos
				Texto multilínea
				""");
		
		System.out.println("Hola\n"
				+ "Que tal\n"
				+ "Prueba");

		String saludo = String.format("Hola %s", nombre);

		System.out.println(saludo);

		System.out.println(Math.pow(5, 3)); // 5 ** 3);
		
		Date date = new Date();
		
		System.out.println(date);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		
		System.out.println(gregorianCalendar);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDateTime);
	}
}
