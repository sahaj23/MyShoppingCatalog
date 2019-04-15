
function validate() {
    var ret = true;
    if (username == "") {
        $("#sp1").text("*Please enter username").css({"color": "red", "font-size": 15});
        ret = false;
    }
    if (password == "") {
        $("#sp2").text("*Please enter password").css({"color": "red", "font-size": 15});
        ret = false;
    }
    return ret;
}


function clearError() {
    $("#regresult").text("");
    $("#username").keypress(function () {
        $("#sp1").text("");
    });
    $("#password").keypress(function () {
        $("#sp2").text("");
    });
}


function connect() {
    username = $("#username").val();
    password = $("#password").val();
    
    var data = {
        username: username,
        password: password
        
    };
    if (validate()) {
        var request = $.post("RegistrationControllerServlet", data, processResponse);
        request.error(handleError);
    }
}

function connectblur(){
    var username=$("#username").val();
    alert(username);
    var data = {
        username: username   
    };
    if(validate()){
        //var link="RegistrationControllerServlet"
        var request=$.get("RegistrationControllerServlet",data,processResponse);
        request.error(handleError);
    }
}


function processResponse(responseText) {
    
    if (responseText.includes('UAP')) {
        $("#sp1").html("Username already taken").css({"color": "red", "font-size": 15});
        return;
    }
    else if (responseText.includes('failure')) {
        $("#regresult").html("Registration failed!").css({"color": "red", "font-size": 15});
        return;
    }
    else if(responseText.includes('Success')){
    $("#regresult").html("<h3>Registration done! </h3>Please wait while we are redirecting you to the home page...").css("color","green");
    setTimeout(function () {
        window.location = "homepage.html";
    }, 6000);
}
}

function handleError(xhr, textStatus) {
    if (textStatus === 'error') {
        $("#regresult").text("An error occured!");
    }

}
