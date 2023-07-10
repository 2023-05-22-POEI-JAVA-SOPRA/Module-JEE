import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		
		
		Connection conn = UtilConnection.seConnecter();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() ) {
				String password = rs.getString("password");
				String login = rs.getString("login");
				String email= rs.getString("email");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int id = rs.getInt("id");
				
				System.out.println(password + "  " + login  + "  " + email  + "  " +  name  + "  " +  age  + "  " +  id);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
