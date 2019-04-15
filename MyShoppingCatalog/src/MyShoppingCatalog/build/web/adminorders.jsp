<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shoppingcatalog.dto.OrderDTO"%>
<%@page import="shoppingcatalog.dao.StoreDAO"%>
<%@page import="shoppingcatalog.dto.ItemDTO"%>
<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <title>Admin Access</title>
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css" >
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="scripts/jquery.js">
        </script>
        <script type="text/javascript" src="scripts/adminoptions.js">
        </script>

    </head>
    <body >
        <div id="logo">
            
            <img src="images/shopping_logo5.png" >
        </div>
        <div align='center'>
        <h1>Orders</h1>
        <p>Please select a category you want to update:</p>
        
<%
    HttpSession sess=request.getSession();
    if(sess.getAttribute("username")==null){
        sess.invalidate();
     response.sendRedirect("accessdenied.html");
    }
    ArrayList<OrderDTO> orders=StoreDAO.getAllOrders();
     SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
    out.println("<table border='2px' style='width:300px;'><th>Order ID</th><th>Amount</th><th>Date</th>");
    for(OrderDTO o:orders){
     out.println("<tr><td><a href='adminorderdetails.jsp?orderid="+o.getOrderId()+"'>"+o.getOrderId()+"</a></td>");
     out.println("<td>"+o.getOrderAmount()+"</td>");
     out.println("<td>"+sdf.format(o.getOrderDate())+"</td></tr>");
    }
    out.println("<a href='adminhomepage.html'>Home</a>");
    out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                
%>      
 
        </div>

    </body>
</html>
