/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter3 implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext sc = filterConfig.getServletContext();

        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();

        sc.log(filterName + " | " + servletPath + " | before request");

        chain.doFilter(httpRequest, response);

        sc.log(filterName + " | " + servletPath + " | after request");
    }

    public void destroy() {
        filterConfig = null;
    }
}
