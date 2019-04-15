package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoppingcatalog.dao.StoreDAO;
import java.util.ArrayList;
import shoppingcatalog.dto.ItemDTO;
import java.util.Enumeration;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Order placed</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\"> \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <div id=\"logo\">\n");
      out.write("                <img src=\"images/shopping_logo5.png\" >\n");
      out.write("            </div>\n");
      out.write("            <div align=\"center\">\n");
      out.write("\n");
      out.write("                ");

                    HttpSession sess = request.getSession();
                    String total=request.getParameter("total");
                    String username=(String)sess.getAttribute("username");
                    out.println("<strong>Thank for shopping with us</strong><br>");
                    out.println("Your payment of Rs."+total+" is under processing...<br>");
                    
                    sess.removeAttribute("itemsInCart");
                    Enumeration e = sess.getAttributeNames();
                    ArrayList<ItemDTO> itemList=new ArrayList<>();
                    while (e.hasMoreElements()) {
                        String id = (String) e.nextElement();
                       // System.out.println(id);
                        if (!id.equals("username")) {
                            System.out.println(id);
                            itemList.add((ItemDTO) sess.getAttribute(id.toString()));
                            sess.removeAttribute(id);
                        }
                    }
                    boolean success=StoreDAO.addOrder(username, itemList, Double.parseDouble(total));
                    if(success) out.println("Your order has been placed<br>");
                    else out.println("Some error occured");
                    out.println("<a href='StoreControllerServlet'>Shop Again</a>");
                
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
