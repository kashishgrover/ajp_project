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
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Employees</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Employee List</h1>");
            
            
            out.println("<table>"
                    + "<tr><td>Hriddhi Dey</td><td><a href='mail.html'>Send mail</a></td></tr>"
                    + "<tr><td>Kashish Grover</td><td><a href='mail.html'>Send mail</a></td></tr>"
                    + "</table>"
                    + "");
            
            out.println("</body>");
            out.println("<a href='portal.html'>Back</a>");
            out.println("</html>");
        }
    }

}
