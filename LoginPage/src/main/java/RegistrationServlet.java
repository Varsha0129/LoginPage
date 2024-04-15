import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegistrationDao registerDao = new RegistrationDao();

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw = response.getWriter();
	      
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // Load the MySQL JDBC driver
       
			String name  = request.getParameter("name");
			String email = request.getParameter("email");
			String mobilenumber = request.getParameter("mobilenumber");
			String password = request.getParameter("password");
			try {
			Registration dao = new Registration();
			dao.setName(name);
			dao.setEmail(email);
			dao.setMobilenumber(mobilenumber);
			dao.setPassword(password);
			System.out.println("data inserted");
			
		registerDao.registerUserDetails(dao);
			}
         catch (Exception e) {
			pw.println("not connected");
				e.printStackTrace();
			}
         
     	response.sendRedirect("welcome.jsp?name=" +name);
         }
}
       