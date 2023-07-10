import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		
		
		Connection conn = UtilConnection.seConnecter();
		//conn.close();
		
		// GET ALL
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				String password = rs.getString("password");
				String login = rs.getString("login");
				String email= rs.getString("email");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int id = rs.getInt("id");
				System.out.println(password + "  " + login  + "  " + email  + "  " +  name  + "  " +  age  + "  " +  id);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// GET By id
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user where id = 3");
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
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// INSERT 
		try {
			PreparedStatement ps = conn.prepareStatement(
"insert into user (name, login, password, email, age) VALUES ('dzaidazjodzaio', 'login', 'secretpassword', 'a@a.a', 32);"
			);
			int result = ps.executeUpdate();
			System.out.println("Insert done :" + result);
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// UPDATE
		try {
			PreparedStatement ps = conn.prepareStatement(
"UPDATE user SET name = 'new name', login = 'new login', password = 'still strong password', age = 29 WHERE id = 5;"
			);
			int result = ps.executeUpdate();
			System.out.println("Update done :" + result);
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// DELETE
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id = 1");
			int result = ps.executeUpdate();
			System.out.println("Delete done :" + result);
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
