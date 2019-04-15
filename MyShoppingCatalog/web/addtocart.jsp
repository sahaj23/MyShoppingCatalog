<%@page import="shoppingcatalog.dao.StoreDAO"%>
<%@page import="shoppingcatalog.dto.ItemDTO"%>
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
        <h1>My Store- Shopping cart</h1>
        <p>Item added successfully!</p>
        
<%
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
%>
<span id="result"></span>
<span id="details"></span>
    </body>
</html>
