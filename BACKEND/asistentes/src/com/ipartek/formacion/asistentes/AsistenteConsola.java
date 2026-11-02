package com.ipartek.formacion.asistentes;

import java.sql.SQLException;

public class AsistenteConsola {
	public static void main(String[] args) {
//		AsistenteDao.insertar(new AsistenteDto(null, "Nuevo", "Nuevez'); DROP TABLE asistentes; -- "));
		try {
			
			int opcion;
			
			do {
				menu();
				opcion = Integer.parseInt(IO.readln("Dime qué opción quieres: "));
				procesarOpcion(opcion);
			} while(opcion != 0);
			
		} catch (Exception e) {
			System.out.println("Error NO ESPERADO");
			
			e.printStackTrace();
		}
	}

	private static void menu() {
		IO.println("""
				MENÚ
				====
				
				1. Listado
				2. Obtener por id
				
				0. Salir
				
				""");
	}

	private static void procesarOpcion(int opcion) throws SQLException {
		switch(opcion) {
		case 1 -> listado();
		case 2 -> obtenerPorId();
		case 0 -> IO.println("Gracias por usar la aplicación");
		default -> IO.println("Opción incorrecta");
		}
	}

	private static void listado() throws SQLException {
		for (AsistenteDto asistente : AsistenteDao.obtenerTodos()) {
			System.out.printf("%2s %-20s %-40s\n", asistente.id(), asistente.nombre(), asistente.apellidos());
		}
	}

	private static void obtenerPorId() throws SQLException {
		Long id;
		
		try {
			id = Long.parseLong(IO.readln("Dime el id que buscas: ").trim());
			System.out.println(AsistenteDao.obtenerPorId(id));
		} catch (NumberFormatException e) {
			System.out.println("La próxima vez, mejor usa un número, campeón");
		}
	}
}
