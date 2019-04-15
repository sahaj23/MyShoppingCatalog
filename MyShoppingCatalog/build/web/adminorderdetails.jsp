
<%@page import="javafx.util.Pair"%>
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
                    System.out.println(orderId+" lol");
                    Pair<String,ArrayList<ItemDTO>> items=StoreDAO.getOrderDetailsAdmin(orderId); 
                    String custName=items.getKey();
                    ArrayList<ItemDTO> itemList=items.getValue();
//                    String date=request.getParameter("orderdate");
//                    out.println("You placed this order on "+date);
                    	custName=custName.substring(0,1).toUpperCase()+custName.substring(1);
                    out.println("<strong>Customer name: "+custName+"</strong>");
                    out.println("<table border='2px'><th>Item name</th><th> Price</th>");
                    double total=0.0;
                    for(ItemDTO o:itemList){
                     out.println("<tr><td>"+o.getItemName()+"</td>");
                     out.println("<td>"+o.getItemPrice()+"</td></tr>");
                     total+=o.getItemPrice();
                    }
                    out.println("</table>");
                    out.println("Total:"+total);
                    out.println("<br><a href='AdminControllerServlet'>Home</a>"
                            + "&nbsp;&nbsp;&nbsp;"
                            + "<a href='adminorders.jsp'>Back to order page</a>");
                    out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                
                %>

                
            </div>

        </div>
    </body>
</html>
