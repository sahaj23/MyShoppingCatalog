<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <title>Our Store</title>
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css" >
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="scripts/jquery.js">
        </script>
        <script type="text/javascript" src="scripts/showitems.js">
        </script>

    </head>
    <body >
        <div id="logo">
            
            <img src="images/shopping_logo5.png" >
        </div>
        <h1>My Categories</h1>
        <p>Select a category to view items</p>
        
<%
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
    
%>
<span id="result"></span>
<span id="details"></span>
    </body>
</html>
