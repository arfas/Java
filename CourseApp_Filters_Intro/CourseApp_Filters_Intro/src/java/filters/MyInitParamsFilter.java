/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyInitParamsFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        ServletContext sc = filterConfig.getServletContext();

        String filterName = filterConfig.getFilterName();

        String logFilename = filterConfig.getInitParameter("logFilename");

        sc.log(filterName + " | logFilename: " + logFilename);

        chain.doFilter(request, response);
    }

    public void destroy() {
        filterConfig = null;
    }
}
