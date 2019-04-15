package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class seestore_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>My Categories</h1>\n");
      out.write("        <p>Select a category to view items</p>\n");
      out.write("        \n");

    HttpSession sess=request.getSession();
    if(sess.getAttribute("username")==null){
        sess.invalidate();
     response.sendRedirect("accessdenied.html");
     
    }
    ArrayList<String> itemTypes = (ArrayList<String>) request.getAttribute("itemTypes");
    out.println("<ul id=\"categories\">");
    for (int i = 0; i < itemTypes.size(); i++) {
        out.println("<li><a href='#' id="+itemTypes.get(i)+" onclick=\"expand(this)\" >+"+itemTypes.get(i)+"</a></li>");
    }
    out.println("</ul>");
    out.println("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
    

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
