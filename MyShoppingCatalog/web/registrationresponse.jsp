<%
  boolean result=(Boolean)request.getAttribute("result");
  boolean userfound=(Boolean)request.getAttribute("userfound");
  //System.out.println(result+" "+userfound+" inside resp");
  if(result){
      
      out.println("Success");
  }
  else if(userfound){
      
    out.println("UAP");
  }
  else {
   out.println("failure");
  }
%>