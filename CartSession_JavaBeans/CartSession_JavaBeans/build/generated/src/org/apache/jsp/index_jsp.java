package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bookstore Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Book list</h1>\n");
      out.write("        <table cellpadding=\"5\" border=1>\n");
      out.write("            <tr valign=\"bottom\">\n");
      out.write("                <td align=\"left\"><b>Title</b></td>\n");
      out.write("                <td align=\"left\"><b>Price</b></td>\n");
      out.write("                <td align=\"left\"></td>\n");
      out.write("            </tr> \n");
      out.write("            <tr valign=\"top\">\n");
      out.write("                <td>Programming in Java</td>\n");
      out.write("                <td>$54.95</td>\n");
      out.write("                <td><a href=\"");
      out.print(response.encodeURL("cart?bookISBN=1234567890"));
      out.write("\">Add To Cart</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr valign=\"top\">\n");
      out.write("                <td>Programming in C#</td>\n");
      out.write("                <td>$42.95</td>\n");
      out.write("                <td><a href=\"");
      out.print(response.encodeURL("cart?bookISBN=2234567890"));
      out.write("\">Add To Cart</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr valign=\"top\">\n");
      out.write("                <td>Programming in C++</td>\n");
      out.write("                <td>$64.95</td>\n");
      out.write("                <td><a href=\"");
      out.print(response.encodeURL("cart?bookISBN=3234567890"));
      out.write("\">Add To Cart</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr valign=\"top\">\n");
      out.write("                <td>Programming in PHP</td>\n");
      out.write("                <td>$34.95</td>\n");
      out.write("                <td><a href=\"");
      out.print(response.encodeURL("cart?bookISBN=4234567890"));
      out.write("\">Add To Cart</a></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
