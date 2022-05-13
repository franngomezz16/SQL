import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select1 {
	public static void main(String[] args) {
		lanzarConsulta();

	}

	private static void lanzarConsulta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda", "root", "fran");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM contacto;");

			while (rs.next()) {
				System.out.println("Contacto " + rs.getInt("id") + ": " + rs.getString("nombre") + " " + rs.getString("email") + " " + rs.getString("telefono"));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
		}

	}
}

//CREATE TABLE contacto (id INT(6) AUTO_INCREMENT PRIMARY KEY,nombre VARCHAR(255) NOT NULL,email VARCHAR(255),telefono VARCHAR(255));
