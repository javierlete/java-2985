package com.ipartek.formacion.asistentes;

import java.sql.SQLException;

public class AsistenteConsola {
	public static void main(String[] args) {
//		AsistenteDao.insertar(new AsistenteDto(null, "Nuevo", "Nuevez'); DROP TABLE asistentes; -- "));
		try {
			AsistenteDao.insertar(new AsistenteDto(null, null, "Nuevez"));
			listado();
		} catch (SQLException e) {
			System.out.println("Error en la inserción. Continuamos.");
		}
		
		try {
			AsistenteDao.modificar(new AsistenteDto(2L, "Modificado", "Modificadez"));
			listado();
		} catch (SQLException e) {
			System.out.println("Error en la modificación. Continuamos.");
		}
		
		try {
			AsistenteDao.borrar(3L);
			listado();
		} catch (SQLException e) {
			System.out.println("Error en el borrado. Continuamos.");
		}
		
		try {
			System.out.println(AsistenteDao.obtenerPorId(2L));
		} catch (SQLException e) {
			System.out.println("Ha fallado el obtener por id");
		}
	}

	private static void listado() throws SQLException {
		for (AsistenteDto asistente : AsistenteDao.obtenerTodos()) {
			System.out.printf("%2s %-20s %-40s\n", asistente.id(), asistente.nombre(), asistente.apellidos());
		}
	}
}
