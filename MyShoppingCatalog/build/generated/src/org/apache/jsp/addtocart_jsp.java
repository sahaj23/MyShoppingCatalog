package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoppingcatalog.dao.StoreDAO;
import shoppingcatalog.dto.ItemDTO;
import java.util.ArrayList;

public final class addtocart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Our Store</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\" >\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/jquery.js\">\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/showitems.js\">\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <div id=\"logo\">\n");
      out.write("            \n");
      out.write("            <img src=\"images/shopping_logo5.png\" >\n");
      out.write("        </div>\n");
      out.write("        <h1>My Store- Shopping cart</h1>\n");
      out.write("        <p>Item added successfully!</p>\n");
      out.write("        \n");

    try{
    HttpSession sess=request.getSession();
    if(sess.getAttribute("username")==null){
        sess.invalidate();
     response.sendRedirect("accessdenied.html");
     
    }
    String itemId=request.getParameter("itemId");
    String itemName=request.getParameter("itemName");
    ItemDTO item=StoreDAO.getItemDetails(Integer.parseInt(itemId));
    sess.setAttribute(String.valueOf(itemId),item);
     int itemsInCart;
     
    if(sess.getAttribute("itemsInCart")!=null){
     itemsInCart=(Integer)(sess.getAttribute("itemsInCart"));
     
     itemsInCart++;
     sess.setAttribute("itemsInCart", itemsInCart);
     
    }
    else{
     itemsInCart=1;
     sess.setAttribute("itemsInCart",itemsInCart);
    }
    //System.out.println("items="+itemsInCart);
    out.println("<p><strong>Item id:</strong>"+itemId+"</p>");
    out.println("<p><strong>Item name:</strong>"+itemName+"</p>");
    out.println("<p><strong>Items in cart:</strong>"+itemsInCart+"</p>");
    out.println("<a href='StoreControllerServlet'>Continue Shopping</a>&nbsp;&nbsp;&nbsp;");
    out.println("<a href='placeorder.jsp'>Place Order</a>");
    out.println("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;"
            + "<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
    }
    catch(Exception ex){
        response.sendRedirect("logout.html");
    }

      out.write("\n");
      out.write("<span id=\"result\"></span>\n");
      out.write("<span id=\"details\"></span>\n");
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
