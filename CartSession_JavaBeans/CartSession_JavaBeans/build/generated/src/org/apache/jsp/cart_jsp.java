package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import business.*;
import java.util.ArrayList;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>Your cart</h1>\n");
      out.write("        <table border=\"1\" cellpadding=\"5\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Title</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Amount</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                Cart cart = (Cart) session.getAttribute("cart");
                ArrayList<OrderItem> items = cart.getItems();
                for (int i = 0; i < items.size(); i++) {
                    OrderItem orderItem = (OrderItem) items.get(i);
                    pageContext.setAttribute("item", orderItem);
            
      out.write("\n");
      out.write("            <tr valign=\"top\">\n");
      out.write("                <td>\n");
      out.write("                    <form action=\"");
      out.print(response.encodeURL("cart"));
      out.write("\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"bookISBN\" \n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.isbn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <input type=text size=2 name=\"quantity\" \n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Update\">\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.priceCurrencyFormat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.totalCurrencyFormat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <form action=\"");
      out.print( response.encodeURL("cart"));
      out.write("\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"bookISBN\" \n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.book.isbn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"quantity\" \n");
      out.write("                               value=\"0\">\n");
      out.write("                        <input type=\"submit\" value=\"Remove Item\">\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"3\">\n");
      out.write("                    <p><b>To change the quantity</b>, enter the new quantity \n");
      out.write("                        and click on the Update button.</p>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"");
      out.print( response.encodeURL("index.jsp"));
      out.write("\" method=\"post\">\n");
      out.write("            <input type=\"submit\" name=\"continue\" value=\"Continue Shopping\">\n");
      out.write("        </form>\n");
      out.write("        <form action=\"");
      out.print( response.encodeURL("checkout.jsp"));
      out.write("\" method=\"post\">\n");
      out.write("            <input type=\"submit\" name=\"checkout\" value=\"Checkout\">\n");
      out.write("        </form>\n");
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
