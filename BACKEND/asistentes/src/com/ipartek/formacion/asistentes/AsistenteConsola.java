package com.ipartek.formacion.asistentes;

import java.sql.SQLException;

import com.ipartek.formacion.bibliotecas.Consola;

public class AsistenteConsola {
	public static void main(String[] args) {
//		AsistenteDao.insertar(new AsistenteDto(null, "Nuevo", "Nuevez'); DROP TABLE asistentes; -- "));
		try {

			Integer opcion;

			do {
				menu();
				opcion = Consola.pedirInt("Dime qué opción quieres: ");
				procesarOpcion(opcion);
			} while (opcion != 0);

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

				3. Insertar
				4. Modificar
				5. Borrar

				0. Salir

				""");
	}

	private static void procesarOpcion(int opcion) throws SQLException {
		switch (opcion) {
		case 1 -> listado();
		case 2 -> obtenerPorId();
		case 3 -> insertar();
		case 4 -> modificar();
		case 5 -> borrar();
		case 0 -> IO.println("Gracias por usar la aplicación");
		default -> IO.println("Opción incorrecta");
		}
	}

	private static void listado() {
		try {
			for (AsistenteDto asistente : AsistenteDao.obtenerTodos()) {
				System.out.printf("%2s %-20s %-40s\n", asistente.id(), asistente.nombre(), asistente.apellidos());
			}
		} catch (SQLException e) {
			IO.println("No se ha podido obtener los asistentes");
		}
	}

	private static void obtenerPorId() {
		Long id = null;

		try {
			id = Consola.pedirLong("Dime el id: ");

			AsistenteDto asistente = AsistenteDao.obtenerPorId(id);

			if (asistente != null) {
				IO.println(asistente);
			} else {
				IO.println("No se ha encontrado el asistente con el id " + id);
			}
		} catch (SQLException e) {
			IO.println("No se ha podido obtener el asistente con el id " + id);
		}
	}

	private static void insertar() {
		try {
			String nombre = Consola.pedirString("Nombre: ");
			String apellidos = Consola.pedirString("Apellidos: ");

			AsistenteDto asistente = new AsistenteDto(null, nombre, apellidos);

			AsistenteDao.insertar(asistente);
		} catch (SQLException e) {
			IO.println("No se ha podido escribir el asistente");
		}
	}

	private static void modificar() {
		try {
			Long id = Consola.pedirLong("Id: ");
			String nombre = Consola.pedirString("Nombre: ");
			String apellidos = Consola.pedirString("Apellidos: ");

			AsistenteDto asistente = new AsistenteDto(id, nombre, apellidos);

			AsistenteDao.modificar(asistente);
		} catch (SQLException e) {
			IO.println("No se ha podido modificar el asistente");
		}
	}

	private static void borrar() {
		Long id = null;

		try {
			id = Consola.pedirLong("Dime el id: ");
			AsistenteDao.borrar(id);
		} catch (SQLException e) {
			IO.println("No se ha podido borrar el asistente con el id " + id);
		}
	}
}
