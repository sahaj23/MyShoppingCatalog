
<%@page import="shoppingcatalog.dto.ItemDTO"%>
<%@page import="java.util.Enumeration"%>
<html>
    <head>
        <title>Order placed</title>
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

                <%
                    HttpSession sess = request.getSession();
                    Enumeration e = sess.getAttributeNames();
                    String username=(String)sess.getAttribute("username");
                    if(username==null){
                     response.sendRedirect("login.html");
                    }
                    double total = 0.0;
                    out.println("<table border='2px' style='width:300px; '><th>Name</th><th>ID</th><th>Price</th>");
                    while (e.hasMoreElements()) {
                        String id = (String) e.nextElement();
                        if (!id.equals("username") && !id.equals("itemsInCart")) {
                            ItemDTO item = (ItemDTO) sess.getAttribute(id.toString());
                            String name = item.getItemName();
                            double price = item.getItemPrice();
                            total += price;
                            out.println("<tr ><td>" + name + "</td>");
                            out.println("<td>" + id + "</td>");
                            out.println("<td>" + price + "</td>");
                            //System.out.println("Here is"+id);
                            out.println("<td><a href='removesess.jsp?id="+id+" '>remove</a></td></tr>");
                            out.println("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;"
            + "<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                        }
                    }
                    out.println("</table>");
                    
                    if(total!=0){
                    out.println("Total amount to pay: Rs." + total);
                    out.println("<br><a href='StoreControllerServlet'>Continue Shopping</a>&nbsp;&nbsp;&nbsp");
                    out.println("<a href='checkout.jsp?total="+total+"'>Checkout</a>");
                    }
                    else {
                        out.println("Your cart is empty");
                        out.println("<br><a href='StoreControllerServlet'>Continue Shopping</a>&nbsp;&nbsp;&nbsp");
                    }
                %>

                
            </div>

        </div>
    </body>
</html>
