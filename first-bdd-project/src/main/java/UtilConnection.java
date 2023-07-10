import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConnection {

	public static Connection seConnecter() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "root");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found :" + e);
		} catch (SQLException e) {
			System.out.println("Sql exception:" + e);
		}
		
		return null;
		
	}
	
	
	
}
