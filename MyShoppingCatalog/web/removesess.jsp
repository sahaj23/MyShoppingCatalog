<%
  String id=request.getParameter("id");  
  HttpSession sess=request.getSession();
  sess.removeAttribute(id);
  int itemsInCart=(Integer)sess.getAttribute("itemsInCart");
  itemsInCart--;
  sess.setAttribute("itemsInCart",itemsInCart);
  System.out.println("ID IS"+id);
  response.sendRedirect("placeorder.jsp");
%>