/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

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
        
        // store the User object in the request object
        request.setAttribute("user", user);
        
        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        /*****************************************
         * Some extra examples
        ***************************************/
        
        // create the Date object and store it in the request
        Date currentDate = new Date();
        request.setAttribute("currentDate", currentDate);
        
        // create an array of strings
        String[] colors = {"red", "green", "blue"};
        ServletContext application = this.getServletContext();
        application.setAttribute("colors", colors);        
        
        // create users list and store it in the session
        ArrayList<User> users = UserIO.getUsers(path);
        session.setAttribute("users", users);
        
        // create users map and store it in the session
        HashMap<String, User> usersMap = UserIO.getUsersMap(path);
        session.setAttribute("usersMap", usersMap);

        // store the email address in the session
        session.setAttribute("emailAddress", emailAddress);
        
        // store an array of email addresses in the session
        String[] emailAddresses = {"carl@gmail.com", "judy@npu.edu"};
        session.setAttribute("emailAddresses", emailAddresses);
        
        // set the email cookie
        Cookie c = new Cookie("emailCookie", emailAddress);
        c.setMaxAge(60*60); //set its age to 1 hour
        c.setPath("/"); //allow the entire application to access it
        response.addCookie(c);

        // store an int value as an attribute
        int userID = 8;
        session.setAttribute("userID", userID);

        // forward request and response objects to JSP page
        String url = "/display_contact_entry.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
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
