/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
import dataaccess.BookIORepository;
import javax.servlet.*;
import java.util.*;
import business.*;

/**
 *
 * @author arfas
 */
public class CartContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext sc = event.getServletContext();      
 
        // initialize the technical support email address that's used throughout the web site
        String supportEmail = sc.getInitParameter("supportEmail");
        sc.setAttribute("supportEmail", supportEmail);

        // initialize the current year that's used in the copyright at the footer
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
        
        // initialize the path for the books text file
        String booksPath = sc.getRealPath("WEB-INF/books.txt");
        sc.setAttribute("booksPath", booksPath);
        
        // initialize the list of books
        ArrayList<Book> books = new ArrayList<Book>();      
        books = BookIORepository.getBooks(booksPath);
        sc.setAttribute("books", books);
    }
    
    public void contextDestroyed(ServletContextEvent event)
    {
        // no cleanup necessary
    }    

}
