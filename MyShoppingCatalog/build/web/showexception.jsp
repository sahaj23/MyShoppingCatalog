<%
   Exception ex=(Exception)request.getAttribute("exception");
   String msg=ex.getMessage();
   System.out.println("Exception is:"+msg);
   out.println(msg);
%>
