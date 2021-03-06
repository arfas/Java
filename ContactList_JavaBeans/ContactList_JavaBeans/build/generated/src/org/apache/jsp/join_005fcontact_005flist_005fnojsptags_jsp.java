package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import business.User;

public final class join_005fcontact_005flist_005fnojsptags_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>NPU Student Club</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Join our contact list</h1>\r\n");
      out.write("        <p>To join our contact list, enter your name and\r\n");
      out.write("            email address below. <br>\r\n");
      out.write("            Then, click on the Submit button.</p>\r\n");
      out.write("        <form action=\"addToContactList\" method=\"post\">\r\n");
      out.write("            \r\n");
      out.write("            ");

                User user = (User) session.getAttribute("user");
                if (user == null) {
                    user = new User();
                }
            
      out.write("\r\n");
      out.write("            <table cellspacing=\"5\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"right\">First name:</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"firstName\" value=\"");
      out.print( user.getFirstName() );
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"right\">Last name:</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"lastName\" value=\"");
      out.print( user.getLastName() );
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"right\">Email address:</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"emailAddress\" value=\"");
      out.print( user.getEmailAddress() );
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                    <td><br><input type=\"submit\" value=\"Submit\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <p><a href=\"addToContactList?firstName=Lily&&lastName=Li&&emailAddress=lily@yahoo.com\">\r\n");
      out.write("                    Display Contact Entry\r\n");
      out.write("                </a>\r\n");
      out.write("            </p>           \r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
