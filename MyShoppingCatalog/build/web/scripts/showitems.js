function expand(a) {
    var itemType = $(a).text();
    txt = itemType.slice(1, itemType.length);
    ref = $("#" + txt);
    if (itemType.substr(0, 1) === "+") {
         $.get("StoreControllerServlet?itemType=" + txt,processresponse);
    }
    else
    {
        $("#"+txt+"type").hide(500);
        ref.html(ref.html().replace("-", "+"));
    }
}
function processresponse(responseText) {
   ref.text(ref.text().trim().replace("+", "-"));
   $(responseText).insertAfter($("#"+txt));
}



