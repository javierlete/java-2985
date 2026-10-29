package com.ipartek.formacion.asistentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Refactorizar para seguir todavía más el principio DRY

public class AsistenteDao {
	private static final String JDBC_URL = "jdbc:sqlit:asistentes.db";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASS = "";
	
	public static ArrayList<AsistenteDto> obtenerTodos() throws SQLException {
		PreparedStatement pst = crearSentencia("SELECT * FROM asistentes");

		ResultSet rs = pst.executeQuery();

		ArrayList<AsistenteDto> asistentes = new ArrayList<>();

		while (rs.next()) {
			AsistenteDto asistente = new AsistenteDto(rs.getLong("id"), rs.getString("nombre"),
					rs.getString("apellidos"));

			asistentes.add(asistente);
		}

		cerrarResultSet(pst, rs);
		
		return asistentes;
	}

	public static AsistenteDto obtenerPorId(Long id) throws SQLException {
		PreparedStatement pst = crearSentencia("SELECT * FROM asistentes WHERE id=?");
		
		pst.setLong(1, id);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			return new AsistenteDto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"));
		}
		
		cerrarResultSet(pst, rs);

		return null;
	}

	public static void insertar(AsistenteDto asistenteDto) throws SQLException {
		PreparedStatement pst = crearSentencia("INSERT INTO asistentes (nombre, apellidos) VALUES (?, ?)");

		pst.setString(1, asistenteDto.nombre());
		pst.setString(2, asistenteDto.apellidos());
		
		pst.executeUpdate();
		
		cerrarSentencia(pst);
	}

	public static void modificar(AsistenteDto asistenteDto) throws SQLException {
		PreparedStatement pst = crearSentencia("UPDATE asistentes SET nombre=?, apellidos=? WHERE id=?");

		pst.setString(1, asistenteDto.nombre());
		pst.setString(2, asistenteDto.apellidos());
		pst.setLong(3, asistenteDto.id());
		
		pst.executeUpdate();
		
		cerrarSentencia(pst);	
	}

	public static void borrar(Long id) throws SQLException {
		PreparedStatement pst = crearSentencia("DELETE FROM asistentes WHERE id=?");

		pst.setLong(1, id);
		
		pst.executeUpdate();
		
		cerrarSentencia(pst);
	}

	private static PreparedStatement crearSentencia(String sql) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
			throw e;
		}
		return con.prepareStatement(sql);
	}

	private static void cerrarSentencia(PreparedStatement pst) throws SQLException {
		pst.close();
		
		pst.getConnection().close();
	}

	private static void cerrarResultSet(PreparedStatement pst, ResultSet rs) throws SQLException {
		rs.close();
		
		cerrarSentencia(pst);
	}

}
