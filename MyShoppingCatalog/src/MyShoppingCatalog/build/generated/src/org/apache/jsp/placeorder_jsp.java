package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoppingcatalog.dto.ItemDTO;
import java.util.Enumeration;

public final class placeorder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Order placed</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\"> \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("            <div id=\"logo\">\n");
      out.write("                <img src=\"images/shopping_logo5.png\" >\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("\n");
      out.write("                ");

                    HttpSession sess = request.getSession();
                    Enumeration e = sess.getAttributeNames();
                    String username=(String)sess.getAttribute("username");
                    if(username==null){
                     response.sendRedirect("login.html");
                    }
                    double total = 0.0;
                    out.println("<table border='2px' style='width:300px; '><th>Name</th><th>ID</th><th>Price</th>");
                    while (e.hasMoreElements()) {
                        String id = (String) e.nextElement();
                        if (!id.equals("username") && !id.equals("itemsInCart")) {
                            ItemDTO item = (ItemDTO) sess.getAttribute(id.toString());
                            String name = item.getItemName();
                            double price = item.getItemPrice();
                            total += price;
                            out.println("<tr ><td align='center'>" + name + "</td>");
                            out.println("<td align='center'>" + id + "</td>");
                            out.println("<td align='center'>" + price + "</td>");
                            //System.out.println("Here is"+id);
                            out.println("<td><a href='removesess.jsp?id="+id+" '>remove</a></td></tr>");
                            out.println("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;"
            + "<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                        }
                    }
                    out.println("</table>");
                    
                    if(total!=0){
                    out.println("Total amount to pay: Rs." + total);
                    out.println("<br><a href='StoreControllerServlet'>Continue Shopping</a>&nbsp;&nbsp;&nbsp");
                    out.println("<a href='checkout.jsp?total="+total+"'>Checkout</a>");
                    }
                    else {
                        out.println("Your cart is empty");
                        out.println("<br><a href='StoreControllerServlet'>Continue Shopping</a>&nbsp;&nbsp;&nbsp");
                    }
                    
                
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
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
