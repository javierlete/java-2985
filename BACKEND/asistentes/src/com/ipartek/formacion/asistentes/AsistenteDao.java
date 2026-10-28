package com.ipartek.formacion.asistentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsistenteDao {
	private static final String JDBC_URL = "jdbc:sqlite:asistentes.db";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASS = "";

	public static ArrayList<AsistenteDto> obtenerTodos() throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM asistentes");

		ArrayList<AsistenteDto> asistentes = new ArrayList<>();

		while (rs.next()) {
			AsistenteDto asistente = new AsistenteDto(rs.getLong("id"), rs.getString("nombre"),
					rs.getString("apellidos"));

			asistentes.add(asistente);
		}

		return asistentes;
	}

	public static AsistenteDto obtenerPorId(Long id) throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM asistentes WHERE id=" + id);

		if (rs.next()) {
			return new AsistenteDto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"));
		}

		return null;
	}

	public static void insertar(AsistenteDto asistenteDto) throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		Statement st = con.createStatement();

		st.executeUpdate(String.format("INSERT INTO asistentes (nombre, apellidos) VALUES ('%s', '%s')",
				asistenteDto.nombre(), asistenteDto.apellidos()));
	}

	public static void modificar(AsistenteDto asistenteDto) throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		Statement st = con.createStatement();

		st.executeUpdate(String.format("UPDATE asistentes SET nombre='%s', apellidos='%s' WHERE id=%s",
				asistenteDto.nombre(), asistenteDto.apellidos(), asistenteDto.id()));
	}

	public static void borrar(Long id) throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		Statement st = con.createStatement();

		st.executeUpdate("DELETE FROM asistentes WHERE id=" + id);
	}

}
