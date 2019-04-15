
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
                <h1>My Orders</h1>
                <%
                    HttpSession sess = request.getSession();
                    String username=(String)sess.getAttribute("username");
                    if(username==null){
                     response.sendRedirect("login.html");
                    }
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                    ArrayList<OrderDTO> orders=StoreDAO.getOrdersByCustomer(username);
                    if(orders.size()==0){
                     out.println("You have not placed any order yet!");
                    }
                    else{
                    out.println("<table border='2px' style='width:350px;'><th>OrderID</th><th> Amount</th><th>Date</th>");
                    for(OrderDTO o:orders){
                     
                     out.println("<tr><td><a href='orderdetails.jsp?orderid="+o.getOrderId()
                             +"&orderdate="+sdf.format(o.getOrderDate())+"'>"+o.getOrderId()+"</td>");
                     out.println("<td>"+o.getOrderAmount()+"</td>");
                     out.println("<td>"+sdf.format(o.getOrderDate())+"</td></tr>");
                    }
                    out.println("</table>");
                    }
                    out.println("<a href='StoreControllerServlet'>Show categories</a>");
                    out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                
                %>

                
            </div>

        </div>
    </body>
</html>
