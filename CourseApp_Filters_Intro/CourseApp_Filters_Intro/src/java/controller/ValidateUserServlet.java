/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import dataaccess.UserRepository;
import helper.CookieHelper;

/**
 *
 * @author arfas
 */
public class ValidateUserServlet extends HttpServlet {

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
        String courseNo = request.getParameter("courseNo");
        HttpSession session = request.getSession();
        synchronized (session) {
            session.setAttribute("courseNo", courseNo);
        }
        User user = (User) session.getAttribute("user");

        String url = "";

        // if the User object doesn't exist, check for the email cookie
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress
                    = CookieHelper.getCookieValue(cookies, "emailCookie");

            // if the email cookie doesn't exist, go to the registration page
            if (emailAddress == null || emailAddress.equals("")) {
                url = "/register.jsp";
            } // otherwise, create the User object from the email cookie
            // and skip the registration page
            else {
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("WEB-INF/ContactList.txt");
                user = UserRepository.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + courseNo + "_handout.jsp";
            }
        } // if the User object exists, skip the registration page
        else {
            url = "/" + courseNo + "_handout.jsp";
        }

        // forward to the view
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
