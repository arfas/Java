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
        // get parameters from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // create user from the parameters
        User user = new User(firstName, lastName, emailAddress);

        // validate the parameters
        String message = "";
        String url = "";
        if (firstName.length() == 0
                || lastName.length() == 0
                || emailAddress.length() == 0) {
            message = "Please fill out all three text boxes.";
            url = "/join_contact_list.jsp";
        } else {
            message = "";

            // read the relative path from the web.xml file
            ServletConfig config = this.getServletConfig();
            String relativePath = config.getInitParameter("relativePathToFile");

            // write the data to the file
            ServletContext context = getServletContext();
            String path = context.getRealPath(relativePath);
            UserIO.add(user, path);

            // test the context init parameter
            String studentClubEmail = context.getInitParameter("studentClubEmail");
            System.out.println("studentClubEmail: " + studentClubEmail);

            url = "/display_contact_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("message", message);

        // forward request and response to the view
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
