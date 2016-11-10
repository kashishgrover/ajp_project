/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author HD
 */
public class MailServlet extends HttpServlet {


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                    
        String to = request.getParameter("to");
        String from = request.getParameter("from");
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.connectiontimeout", "3000");
        properties.put("mail.smtp.timeout", "3000");
        Session session = Session.getInstance(properties);
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(request.getParameter("subject"));
            message.setText(request.getParameter("mailbody"));
            Transport.send(message);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MailServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mail Sent Successfully.</h1>");
            out.println("<p>Redirecting in 5 seconds...</p>");
            out.println("<script>setTimeout(function(){window.location.href='portal.html'},5000);</script>");
            out.println("</body>");
            out.println("</html>");
        } catch (MessagingException ex) {
            Logger.getLogger(MailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
