
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
    $("#loginresult").text("");
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
    usertype = $("#usertype").val();
    var data = {
        username: username,
        password: password,
        usertype: usertype
    };
    if (validate()) {
        var request = $.post("LoginControllerServlet", data, processResponse);
        request.error(handleError);
    }
}


function processResponse(responseText) {
    if (responseText.includes('error')) {
        $("#loginresult").html("Wrong creds").css({"color": "red", "font-size": 15});
        return;
    }
    url=responseText.trim();
    $("#loginresult").html("<h3>Login Accepted!</h3>Please wait while we are redirecting you to the home page...").css("color","green");
    setTimeout(function () {
        window.location = url;
    }, 3000);
}


function handleError(xhr, textStatus) {
    if (textStatus === 'error') {
        $("#loginresult").text("An error occured!");
    }

}
