package com.ipartek.formacion.bibliotecas;

public class Consola {
	public static String pedirString(String mensaje) {
		boolean correcto = false;
		
		String texto;
		
		do {
			texto = IO.readln(mensaje);
			
			if (texto.isBlank()) {
				IO.println("No se admite texto en blanco");
			} else {
				correcto = true;
			}
		} while (!correcto);
		
		return texto.trim();
	}
	
	public static Integer pedirInt(String mensaje) {
		boolean correcto = false;
		
		Integer entero = null;
		
		do {
			try {
				entero = Integer.parseInt(IO.readln(mensaje).trim());
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("La próxima vez, mejor usa un número, campeón");
			} 
		} while (!correcto);
		
		return entero;
	}
	
	public static Long pedirLong(String mensaje) {
		boolean correcto = false;
		
		Long dato = null;
		
		do {
			try {
				dato = Long.parseLong(IO.readln(mensaje).trim());
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("La próxima vez, mejor usa un número, campeón");
			} 
		} while (!correcto);
		
		return dato;
	}
}
