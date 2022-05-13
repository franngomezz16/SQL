import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert1 {
	public static void main(String[] args) {

		insertarContacto();
	}

	public static void insertarContacto() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda","root","fran");
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("INSERT INTO contacto (nombre,email) VALUES ('Federico','federico@gmail.com');");
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
		}

	}
}
