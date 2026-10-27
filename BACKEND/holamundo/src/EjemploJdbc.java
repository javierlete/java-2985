import java.sql.*;

public class EjemploJdbc {

	private static final String FORMATO = "%2s %-10s %-20s\n";

	void main() throws SQLException {
		String url = "jdbc:sqlite:asistentes.db";
		String user = "";
		String pass = "";

		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();

		st.executeUpdate("INSERT INTO asistentes (nombre, apellidos) VALUES ('Juan', 'González')");
		
		ResultSet rs = st.executeQuery("SELECT * FROM asistentes");

		while (rs.next()) {
			System.out.printf(FORMATO, rs.getString("id"), rs.getString("nombre"), rs.getString("apellidos"));
		}
		
	}
}