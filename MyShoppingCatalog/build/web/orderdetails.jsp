
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shoppingcatalog.dao.StoreDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shoppingcatalog.dto.OrderDTO"%>
<%@page import="shoppingcatalog.dto.ItemDTO"%>
<%@page import="java.util.Enumeration"%>
<html>
    <head>
        <title>My orders</title>
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css"> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        
        <div>
            <div id="logo">
                <img src="images/shopping_logo5.png" >
            </div>
            <div align="center">
                <h1>Order details</h1>
                <%
                    HttpSession sess = request.getSession();
                    String username=(String)sess.getAttribute("username");
                    if(username==null){
                     response.sendRedirect("login.html");
                    }
                    String orderId=request.getParameter("orderid");
                    
                    ArrayList<ItemDTO> items=StoreDAO.getItemsInOrder(orderId);      
                    String date=request.getParameter("orderdate");
                    out.println("You placed this order on "+date);
                    out.println("<table border='2px'><th>Item name</th><th> Price</th>");
                    double total=0.0;
                    for(ItemDTO o:items){
                     out.println("<tr><td>"+o.getItemName()+"</td>");
                     out.println("<td>"+o.getItemPrice()+"</td></tr>");
                     total+=o.getItemPrice();
                    }
                    out.println("</table>");
                    out.println("Total:"+total);
                    out.println("<br><a href='StoreControllerServlet'>Show categories</a>"
                            + "&nbsp;&nbsp;&nbsp;"
                            + "<a href='myorders.jsp'>Back to order page</a>");
                %>

                
            </div>

        </div>
    </body>
</html>
