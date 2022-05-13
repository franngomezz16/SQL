
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Insert2 {
		
		public static String plantilla = "INSERT INTO contacto (nombre,email,telefono) VALUES ('<nombre>','<email>','<telefono>');";
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Introduce un email: ");
		String email = teclado.nextLine();
		System.out.print("Introduce un telefono: ");
		String telefono = teclado.nextLine();
		insertarContacto(nombre,telefono,email);
		teclado.close();
	}

	public static void insertarContacto(String nombre,String email,String telefono) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda","root","fran");
			Statement stmt = conn.createStatement();
			//FORMA1
			String query = plantilla.replaceAll("<nombre>", nombre).replaceAll("<email>", email).replaceAll("<telefono>", telefono);
			stmt.executeUpdate(query);
			//FORMA2
			//stmt.executeUpdate("INSERT INTO contacto (nombre,email,telefono) VALUES ('" + nombre + "','" + email + "','" + telefono + "');");
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
		}

	}
}