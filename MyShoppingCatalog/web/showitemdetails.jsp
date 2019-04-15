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
        <h1>My Store- Item Details</h1>
        <p>You are viewing:</p>
        
        
<%
    HttpSession sess=request.getSession();
   // System.out.println(sess.getAttribute("username"));
    if(sess.getAttribute("username")==null){
        sess.invalidate();
     response.sendRedirect("accessdenied.html");
    }
    ItemDTO item=(ItemDTO) request.getAttribute("details");
    String itemType=item.getItemType();
    String itemName=item.getItemName();
    double itemPrice=item.getItemPrice();
    String itemDesc=item.getItemDesc();
    String itemImage=item.getItemImage();
    int itemId=item.getItemId();
   // out.println("<img src='images/"+itemImage+"/" >");
   out.println("<p><a href='StoreControllerServlet'>"+itemType+"</a>>"+itemName+"</p>");
   out.println("<img src='images/" + itemImage + "' id='itemimg' />");
   out.println("<div id='desc'><h3 style='margin-bottom: 0px;'><strong>Description: </strong></h3>");
   out.println(itemDesc);
    out.println("<br><br><strong><h3 style='display: inline;'>Price:</h3></strong> Rs. "+itemPrice);
    
   // sess.setAttribute("itemsInCart",itemsInCart);
    out.println("<br><br><p><a href='addtocart.jsp?itemId="+itemId+"&itemName="+itemName+"'>Add to cart</a></p></div>");
    out.println("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
    
%>


    </body>
</html>
