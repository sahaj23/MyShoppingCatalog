<%@page import="shoppingcatalog.dto.ItemDTO"%>
<%
    ItemDTO item=(ItemDTO)request.getAttribute("details");
    String pName=item.getItemName();
    String pType=item.getItemType();
    double pPrice=item.getItemPrice();
    String pDesc=item.getItemDesc();
    String pImage=item.getItemImage();
  out.println(pName+"\n"+pType+"\n"+pPrice+"\n"+pImage+"\n"+pDesc);  
//out.println(pType);
//out.println(pPrice);
//out.println(pImage);
//out.println(pDesc);
%>