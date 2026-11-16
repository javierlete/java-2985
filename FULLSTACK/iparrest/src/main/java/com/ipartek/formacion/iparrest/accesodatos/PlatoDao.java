package com.ipartek.formacion.iparrest.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.iparrest.entidades.Plato;

public class PlatoDao {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR AL CARGAR EL DRIVER DE SQLITE");
		}
	}

	public static ArrayList<Plato> obtenerTodos() {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM platos");
				ResultSet rs = pst.executeQuery();) {

			ArrayList<Plato> platos = new ArrayList<>();

			while (rs.next()) {
				Plato plato = new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), null);

				platos.add(plato);
			}

			return platos;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static Plato obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM platos WHERE id=?");) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
						rs.getString("descripcion"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static Plato insertar(Plato plato) {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO platos (nombre, precio, descripcion) VALUES (?,?,?)",
						Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, plato.getNombre());
			pst.setBigDecimal(2, plato.getPrecio());
			pst.setString(3, plato.getDescripcion());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			rs.next();

			plato.setId(rs.getLong(1));

			return plato;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static Plato modificar(Plato plato) {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement(
						"UPDATE platos SET nombre=?, precio=?, descripcion=? WHERE id=?");) {

			pst.setString(1, plato.getNombre());
			pst.setBigDecimal(2, plato.getPrecio());
			pst.setString(3, plato.getDescripcion());
			pst.setLong(4, plato.getId());

			pst.executeUpdate();

			return plato;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void borrar(Long id) {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement(
						"DELETE FROM platos WHERE id=?");) {

			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
