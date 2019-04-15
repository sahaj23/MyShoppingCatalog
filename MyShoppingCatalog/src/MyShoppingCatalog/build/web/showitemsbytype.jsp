<%@page import="java.util.ArrayList"%>
<%@page import="shoppingcatalog.dto.ItemInfoDTO"%>
<script>
<script type="text/javascript" src="scripts/showitems.js">
<script type="text/javascript" src="scripts/jquery.js">
</script>
<%
  ArrayList<ItemInfoDTO> items=(ArrayList<ItemInfoDTO>)request.getAttribute("items"); 
  String itemType=(String)request.getAttribute("itemType");
  out.println("<ul id='"+itemType+"type'>");
  for(int i=0;i<items.size();i++){
     out.println("<li><a href=\"StoreControllerServlet?itemId="+items.get(i).getItemId()+"\">"+items.get(i).getItemName()+"</a>");
  }
  out.println("</ul>");
%>
