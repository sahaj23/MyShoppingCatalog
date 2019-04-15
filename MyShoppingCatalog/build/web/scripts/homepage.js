$(document).ready(function(){
   $("#nextbtn").click(function(){
      doTask(); 
   }); 
});

function doValidate(){
    $("#result").css("display","inline");
    isRegChecked=$("#rbtnReg").is(':checked');
    isLogChecked=$("#rbtnLog").is(':checked');
    var status=true;
    
    if(isRegChecked===false && isLogChecked===false){
        $("#result").text("Please select an option first").css({"font-weight":"bold","color":"red"});
       // $("#result").fadeOut(4000);
        status=false;
    }
    return status;
}

function doTask(){
    var ans=doValidate();
    if(ans==false){
        return;
    }
    if(isRegChecked==true){
        window.location="registration.html";
    }
    if(isLogChecked==true){
        window.location="login.html";
    }
}
