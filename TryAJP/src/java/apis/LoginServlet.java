/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HD
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(username.equals("hriddhi") && password.equals("qwe123")){
                out.println("<h1>Successful Login!</h1><h2> Welcome " + username + "!</h2>");
                out.println("<p>Redirecting in 5 seconds...</p>");
                out.println("<script>setTimeout(function(){window.location.href='portal.html'},5000);</script>");
            }
            else if(username.equals("kashish") && password.equals("zildjian")){
                out.println("<h1>Successful Login!</h1><h2> Welcome " + username + "!</h2>");
                out.println("<p>Redirecting in 5 seconds...</p>");
                out.println("<script>setTimeout(function(){window.location.href='portal.html'},5000);</script>");
            }
            else {
                out.println("<p>Login failed.</p>");
                out.println("<script>setTimeout(function(){window.location.href='index.html'},5000);</script>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
}
