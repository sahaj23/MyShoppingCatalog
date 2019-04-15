package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import shoppingcatalog.dao.StoreDAO;
import java.util.ArrayList;
import shoppingcatalog.dto.OrderDTO;
import shoppingcatalog.dto.ItemDTO;
import java.util.Enumeration;

public final class orderdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>My orders</title>\n");
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
      out.write("                <h1>My Orders</h1>\n");
      out.write("                ");

                    HttpSession sess = request.getSession();
                    String username=(String)sess.getAttribute("username");
                    if(username==null){
                     response.sendRedirect("login.html");
                    }
                    String orderId=request.getParameter("orderid");
                    
                    ArrayList<ItemDTO> items=StoreDAO.getItemsInOrder(orderId);      
                    out.println("<table border='2px'><th>Item name</th><th> Price</th>");
                    for(ItemDTO o:items){
                     out.println("<tr><td>"+o.getItemName()+"</td>");
                     out.println("<td>"+o.getItemPrice()+"</td></tr>");
                    }
                    out.println("</table>");
                    
                    out.println("<a href='StoreControllerServlet'>Show categories</a>");
                
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
