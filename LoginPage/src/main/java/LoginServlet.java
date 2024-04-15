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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details", "root", "varu138");
            logger.log(Level.INFO, "Connected to database");

            String query = "SELECT userName, password FROM registration_details WHERE userName=? AND password=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            
           
            
			
			
            rs = pstmt.executeQuery();
System.out.println(rs);
            if (rs.next()) {
                // Login successful
            	
            		response.sendRedirect("welcome.jsp");
            } else {
                // Login unsuccessful
                pw.println("<h1 style='text-align:center; color:green; margin-top:45vh; background-image:url(\"login.avif\")'>LOGIN UNSUCCESSFUL...!</h1>");
                pw.println("<a href='signin.jsp'>TRY AGAIN</a>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Exception occurred", e);
            pw.println("<h1 style='text-align:center; color:red;'>An error occurred. Please try again later.</h1>");
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error closing resources", e);
            }
        }
    }
}
