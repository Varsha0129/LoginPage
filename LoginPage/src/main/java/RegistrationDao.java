import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao {

	public int registerUserDetails(Registration user) throws ClassNotFoundException{
		
		
		
		String Insert_users ="insert into registration_details"
				+ "(userName , userEmail ,userNumber,password ) values"
				+"(? ,? , ? , ?);";
			
		int result=0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details", "root", "varu138");
		PreparedStatement preparestmt =cn.prepareStatement(Insert_users);
		preparestmt.setInt(1,1);
		preparestmt.setString(2, user.getName());
		preparestmt.setString(3, user.getEmail());
		preparestmt.setString(2, user.getMobilenumber());
		preparestmt.setString(2, user.getPassword());
		
		result = preparestmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return result;
	}
	
	
}
