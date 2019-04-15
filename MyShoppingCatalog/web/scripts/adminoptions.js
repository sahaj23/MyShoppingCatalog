function expand(a) {
    var itemType = $(a).text();
    txt = itemType.slice(1, itemType.length);
    ref = $("#" + txt);
    if (itemType.substr(0, 1) === "+") {
         ref.text(ref.text().trim().replace("+", "-"));
         $("#"+txt+"List").css('display','block');
        // ref.css('display','unset');
    }
    else
    {
        $("#image").hide();
        $(".forms").hide();
        $("#"+txt+"List").css('display','none');
        ref.html(ref.html().replace("-", "+"));
    }
}
function callName(){
    $("#removeuserform").toggle();
    $("#updateform").hide();
    $("#deleteform").hide();
    $("#deleteform").hide();
    $("addform").show();
    var data = {needUserId: "yes"};
    $("#usernames").load("StoreControllerServlet", data).append();
    
}
function removeUser(){
    var userName=$("#usernames").val();
    var data={
        remove:"yes",
        userName:userName
    };
    $.get("StoreControllerServlet",data,processResponseRemoveUser);
}
function processResponseRemoveUser(responseText){
    alert(responseText);
    callName();
    $("removeuserform").show();
}



