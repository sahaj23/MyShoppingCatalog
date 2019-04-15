
<%@page import="shoppingcatalog.dao.StoreDAO"%>
<%@page import="java.util.ArrayList"%>
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
                    String total=request.getParameter("total");
                    String username=(String)sess.getAttribute("username");
                    out.println("<strong>Thank for shopping with us</strong><br>");
                    out.println("Your payment of Rs."+total+" is under processing...<br>");
                    
                    sess.removeAttribute("itemsInCart");
                    Enumeration e = sess.getAttributeNames();
                    ArrayList<ItemDTO> itemList=new ArrayList<>();
                    while (e.hasMoreElements()) {
                        String id = (String) e.nextElement();
                       // System.out.println(id);
                        if (!id.equals("username")) {
                            System.out.println(id);
                            itemList.add((ItemDTO) sess.getAttribute(id.toString()));
                            sess.removeAttribute(id);
                        }
                    }
                    boolean success=StoreDAO.addOrder(username, itemList, Double.parseDouble(total));
                    if(success) out.println("Your order has been placed<br>");
                    else out.println("Some error occured");
                    out.println("<a href='StoreControllerServlet'>Shop Again</a>");
                    out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                
                %>

                
            </div>

        </div>
    </body>
</html>
