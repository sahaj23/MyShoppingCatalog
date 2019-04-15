<%@page import="java.util.ArrayList"%>
<%
  ArrayList<Integer> ids=(ArrayList<Integer>)request.getAttribute("ids"); 
  request.removeAttribute("ids");
  out.println("<option value='default' selected='true' disabled='disabled'>Select ID<option>");
  
  for(int i:ids){
   out.println("<option value="+i+">"+i+"</option>");
  }
%>