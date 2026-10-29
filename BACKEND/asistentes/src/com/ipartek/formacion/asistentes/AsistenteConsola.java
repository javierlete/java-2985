package com.ipartek.formacion.asistentes;

import java.sql.SQLException;

public class AsistenteConsola {
	public static void main(String[] args) {
//		AsistenteDao.insertar(new AsistenteDto(null, "Nuevo", "Nuevez'); DROP TABLE asistentes; -- "));
		try {
			AsistenteDao.insertar(new AsistenteDto(null, null, "Nuevez"));
			listado();

			AsistenteDao.modificar(new AsistenteDto(2L, "Modificado", "Modificadez"));
			listado();

			AsistenteDao.borrar(3L);
			listado();

			System.out.println(AsistenteDao.obtenerPorId(2L));
		} catch (Exception e) {
			System.out.println("Error NO ESPERADO");
		}
	}

	private static void listado() throws SQLException {
		for (AsistenteDto asistente : AsistenteDao.obtenerTodos()) {
			System.out.printf("%2s %-20s %-40s\n", asistente.id(), asistente.nombre(), asistente.apellidos());
		}
	}
}
