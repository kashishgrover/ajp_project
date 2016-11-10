package apis;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HD
 */
public class AddServlet extends HttpServlet {
    
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    final String USER = "kashish";
    final String PASS = "Zildjian1";
    
    Connection conn;   
    Statement stmt = null;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = (Statement) conn.createStatement();
            
            String query = "insert into Employee values(\"" + request.getParameter("name")
                    + "\", \"" + request.getParameter("email") + "\", \"" +
                    request.getParameter("dept") + "\");";
            
            stmt.executeUpdate(query);
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Successfully added Employee " + request.getParameter("name") + "</h2>");
            out.println("<br><br><a href='portal.html'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
