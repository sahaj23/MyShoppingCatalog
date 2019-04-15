package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoppingcatalog.dto.ItemDTO;
import java.util.ArrayList;

public final class adminhomepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Admin Access</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\" >\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/jquery.js\">\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/adminoptions.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/forms.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <div id=\"logo\">\n");
      out.write("\n");
      out.write("            <img src=\"images/shopping_logo5.png\" >\n");
      out.write("        </div>\n");
      out.write("        <h1>Admin Options</h1>\n");
      out.write("        <p>Please select a category you want to update:</p>\n");
      out.write("\n");
      out.write("        ");

            HttpSession sess = request.getSession();
            if (sess.getAttribute("username") == null) {
                sess.invalidate();
                response.sendRedirect("accessdenied.html");

            }

            out.println("<ul style='list-style-type:none'>");
            out.println("<li><a href='#'  onclick='expand(this)' id='Products'>+Products</a>");
            out.println("<ul style='display:none;margin-left: 10px'  id='ProductsList'  >");
            out.println("<li><a href='#' onclick='addLink()'>Add</a></li>"
                    + "<li><a href='#' onclick='updateLink()'>Update</a></li>"
                    + "<li><a href='#' onclick='deleteLink()'>Delete</a></li></ul>");
            out.println("</li><li><a href='#'  onclick='expand(this)' id='Users'>+Users</a>"
                    + "<ul style='display:none' id='UsersList'>"
                    + "<li><a href='#' onclick='callName()'>Remove</a></li> </ul></li>");
            out.println("<li><a href='#'  onclick='expand(this)' id='View'>+View</a>"
                    + "<ul style='display:none' id='ViewList'>"
                    + "<li><a href='adminorders.jsp'>Orders</a></li></ul></li>");
            out.println("</ul>");
            out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
            out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form id=\"addform\" class=\"forms\" enctype='multipart/form-data'>\n");
      out.write("            <p class=\"formtitle\">Add Item</p>\n");
      out.write("            <div align='center'>\n");
      out.write("                <p><b>Product Name:</b> <input type=\"text\" name=\"productName\" id=\"pNameAdd\" ></p>\n");
      out.write("                <p><b>Product Type: </b><input type=\"text\" name=\"productType\" id=\"pTypeAdd\"></p>\n");
      out.write("                <p><b>Product Price: </b><input type=\"text\" name=\"productPrice\" id=\"pPriceAdd\"></p>\n");
      out.write("                <p><b>Product Desc: </b><input type=\"text\" name=\"productDesc\" id=\"pDescAdd\"></p>\n");
      out.write("                <p> <input type=\"file\" name=\"productImage\" accept=\"image/*\" id=\"pImageAdd\"></p>\n");
      out.write("\n");
      out.write("                <button type=\"button\" id=\"addproduct\" onclick=\"addProduct()\">Add Product</button>\n");
      out.write("                <button type=\"button\" id=\"clear\" onclick=\"clearForm('addform')\">Clear</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <form id='updateform' class=\"forms\" enctype='multipart/form-data'>\n");
      out.write("            <p class=\"formtitle\">Update Item</p>\n");
      out.write("            <div align='center'>\n");
      out.write("                <p><b>Product ID:</b> <select onchange=\"update()\" id=\"id\"></select></p>\n");
      out.write("                <p><b>Product Name:</b> <input type=\"text\" name=\"productName\" id=\"pName\"></p>\n");
      out.write("                <p><b>Product Type: </b><input type=\"text\" name=\"productType\" id=\"pType\"></p>\n");
      out.write("                <p><b>Product Price: </b><input type=\"text\" name=\"productPrice\" id=\"pPrice\"></p>\n");
      out.write("                <p><b>Product Desc: </b><input type=\"text\" name=\"productDesc\" id=\"pDesc\"></p>\n");
      out.write("                <p> <input type=\"file\" name=\"productImage\" accept=\"image/*\" onchange=\"changePic(this)\"id=\"pImage\"></p>\n");
      out.write("\n");
      out.write("                <button type=\"button\" id=\"updateproduct\" onclick=\"updateProduct()\">Update Product</button>\n");
      out.write("                <button type=\"button\" id=\"clear\" onclick=\"clearForm('updateform')\" >Clear</button>\n");
      out.write("                <span id=\"sp2\"></span>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <img id='image'>\n");
      out.write("\n");
      out.write("        <form id='deleteform' name=\"delete\" class=\"forms\">\n");
      out.write("            <p class=\"formtitle\">Delete Item</p>\n");
      out.write("            <div align='center'>\n");
      out.write("                <p><b>Product ID:</b> <select onchange=\"deletef()\" id=\"iddelete\"> </select></p>\n");
      out.write("                <p><b>Product Name:</b> <input type=\"text\" name=\"productName\" id=\"pNameD\"></p>\n");
      out.write("                <p><b>Product Type: </b><input type=\"text\" name=\"productType\" id=\"pTypeD\"></p>\n");
      out.write("                <p><b>Product Price: </b><input type=\"text\" name=\"productPrice\" id=\"pPriceD\"></p>\n");
      out.write("                <p><b>Product Desc: </b><input type=\"text\" name=\"productDesc\" id=\"pDescD\"></p>\n");
      out.write("                <button type=\"button\" id=\"deleteproduct\" onclick=\"deleteProduct()\">Delete Product</button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <img id='imageD'>\n");
      out.write("        <form id=\"removeuserform\" class='forms'>\n");
      out.write("             <p class=\"formtitle\">Remove User</p>\n");
      out.write("             <div align='center'>\n");
      out.write("                 <p> <select id='usernames'></select><p>\n");
      out.write("                     <button type=\"button\" id=\"removeuserbtn\" onclick=\"removeUser()\">Remove User</button>\n");
      out.write("             </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
