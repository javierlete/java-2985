package com.ipartek.formacion.asistentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Refactorizar para seguir todavía más el principio DRY

public class AsistenteDao {
	private static final String JDBC_URL = "jdbc:sqlite:asistentes.db";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASS = "";

	public static ArrayList<AsistenteDto> obtenerTodos() throws SQLException {
		try (PreparedStatement pst = crearSentencia("SELECT * FROM asistentes"); ResultSet rs = pst.executeQuery()) {
			ArrayList<AsistenteDto> asistentes = new ArrayList<>();

			while (rs.next()) {
				AsistenteDto asistente = new AsistenteDto(rs.getLong("id"), rs.getString("nombre"),
						rs.getString("apellidos"));

				asistentes.add(asistente);
			}

			return asistentes;
		} catch (SQLException e) {
			System.out.println("No se ha podido pedir los asistentes");
			throw e;
		}
	}

	public static AsistenteDto obtenerPorId(Long id) throws SQLException {
		try (PreparedStatement pst = crearSentencia("SELECT * FROM asistentes WHERE id=?")) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return new AsistenteDto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"));
			}

			return null;
		} catch (SQLException e) {
			System.out.println("No se ha podido hacer la búsqueda por id");
			throw e;
		}
	}

	public static void insertar(AsistenteDto asistenteDto) throws SQLException {
		try (PreparedStatement pst = crearSentencia("INSERT INTO asistentes (nombre, apellidos) VALUES (?, ?)")) {
			pst.setString(1, asistenteDto.nombre());
			pst.setString(2, asistenteDto.apellidos());

			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("No se ha podido hacer la inserción");
			
			e.printStackTrace();
			
			throw e;
		}
	}

	public static void modificar(AsistenteDto asistenteDto) throws SQLException {
		try (PreparedStatement pst = crearSentencia("UPDATE asistentes SET nombre=?, apellidos=? WHERE id=?")) {
			pst.setString(1, asistenteDto.nombre());
			pst.setString(2, asistenteDto.apellidos());
			pst.setLong(3, asistenteDto.id());

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("No se ha podido modificar el registro");
			throw e;
		}
	}

	public static void borrar(Long id) throws SQLException {
		try (PreparedStatement pst = crearSentencia("DELETE FROM asistentes WHERE id=?")) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("No se ha podido borrar el registro");
			throw e;
		}
	}

	private static PreparedStatement crearSentencia(String sql) throws SQLException {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			return con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos");
			throw e;
		}
	}

}
