/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.User;
import data.UserIO;

/**
 *
 * @author arfas
 */
public class AddToContactListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // get a relative file name
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/ContactList.txt");

        // use regular Java objects to write the data to a file
        User user = new User(firstName, lastName, emailAddress);
        UserIO.add(user, path);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToContactListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thanks for joining our contact list</h1>");
            out.println("<p>Here is the information that you entered:</p>");
            out.println("<table cellspacing=\"5\" cellpadding=\"5\" border=\"1\">");
            out.println("<tr><td align=\"right\">First name:</td>\n");
            out.println("<td>" + firstName + "</td >");
            out.println("</tr>");
            out.println("<tr><td align=\"right\">Last name:</td>");
            out.println("<td>" + lastName + "</td >");
            out.println("</tr>");
            out.println("<tr><td align=\"right\">Email address:</td>");
            out.println("<td>" + emailAddress + "</td >");
            out.println("</tr >");
            out.println("</table >");
            out.println("<p>To enter another email address, click on the Back <br>");
            out.println("button in your browser or the Return button shown <br>");
            out.println("below.</p>\n");
            out.println("<form action=\"join_contact_list.html\" ");
            out.println("method=\"post\">\n");
            out.println("<input type=\"submit\" value=\"Return\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
