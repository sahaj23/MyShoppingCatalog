<%@page import="java.util.ArrayList"%>
<%
  ArrayList<String> ids=(ArrayList<String>)request.getAttribute("uid");
  out.println("alert('lola')");
  
  out.println("<option value='default' selected='true' disabled='disabled'>Select ID<option>");
  for(String id:ids){
   out.println("<option>"+id+"</option>");
  }
%>
