function addLink() {
    $("#image").hide();
    $("#addform").toggle();
    $("#updateform").hide();
    $("#deleteform").hide();
    $("#removeuserform").hide();
}
function add(){
    var pName = $("#pNameAdd").val();
    var pPrice = $("#pPriceAdd").val();
    var itemType = $("#pTypeAdd").val();
    var pDesc = $("#pDescAdd").val();
    var pImage = $("#pImageAdd").val();
    var imgName = pImage.replace(/^.*[\\\/]/, '');
    if(pName!="" && pPrice!="" && itemType!="" && pDesc!="" && imgName!=""){
        
    var r = confirm("Are you sure you want to update the item?");
    var data = { add: "yes", pName: pName, pPrice: pPrice, pType: itemType, pDesc: pDesc, pImage: imgName};
    if (r == true) {
        $.get("StoreControllerServlet", data, processResponseAdd);
    }
    }
}
function processResponseAdd(responseText){
    alert("Item added successfully");
    $("#addform").hide();
}
function updateLink() {
    
    var data = {needId: "yes"};
    $("#id").load("StoreControllerServlet", data).append();
    var id = $("#id").val();
    $("#addform").hide();
    $("#deleteform").hide();
    $("#updateform").toggle();
    $("#updateform").trigger("reset");
    $("#image").toggle();
    $("#image").hide();
    $("#removeuserform").hide();
}
function deleteLink() {
    var data = {needId: "yes"};
    $("#iddelete").load("StoreControllerServlet", data).append();
    var id = $("#iddelete").val();
    $("#iddelete").val(id);
    $("#updateform").hide();
    $("#addform").hide();
    $("#deleteform").toggle();
    $("#deleteform").trigger("reset");
    $("#imageD").toggle();
    $("#imageD").hide();
    $("#removeuserform").hide();
}
function clearForm(a){
    $("#image").hide();
   $("#"+a).trigger("reset");
}
function update() {
    var id = $("#id").val();
    if (id != "default") {
        $("#id").val(id);
        var data1 = {details: "yes", itemId: id};
        $.get("StoreControllerServlet", data1, processResponse);
    }
}
function changePic(a){
    var pImage=$("#pImage").val();
    var imgName = pImage.replace(/^.*[\\\/]/, '');
    $("#image").attr("src", "images/"+imgName );
}
function deletef() {
    var id = $("#iddelete").val();
    if (id != "default") {
        $("#iddelete").val(id);
        var data1 = {details: "yes", itemId: id};
        $.get("StoreControllerServlet", data1, processResponseD);
    }
}
function processResponse(responseText) {
    var array = responseText.split("\n");
    $("#image").attr("src", "images/" + array[4]);
    $("#image").show();
    $("#pName").val(array[1]);
    $("#pType").val(array[2]);
    $("#pPrice").val(array[3]);
    $("#pDesc").val(array[5]);
}
function processResponseD(responseText) {
    var array = responseText.split("\n");
    $("#imageD").attr("src", "images/" + array[4]);
    $("#imageD").show();
    $("#pNameD").val(array[1]);
    $("#pTypeD").val(array[2]);
    $("#pPriceD").val(array[3]);
    $("#pDescD").val(array[5]);
}
function deleteProduct() {
    var id = $("#iddelete").val();
    var r = confirm("Are you sure you want to delete the item?");
    var data = {itemId: id, delete: "yes"};
    if (r == true) {
        $.get("StoreControllerServlet", data, processResponseDelete);
    }
}
function processResponseDelete(responseText) {
    $("#deleteform").hide();
}

function updateProduct() {
    var id = $("#id").val();
    var pName = $("#pName").val();
    var pPrice = $("#pPrice").val();
    var itemType = $("#pType").val();
    var pDesc = $("#pDesc").val();
    var pImage = $("#pImage").val();
    var imgName = pImage.replace(/^.*[\\\/]/, '');
    alert(pName!="" && pPrice!="" && itemType!="" && pDesc!="" && imgName!="");
    if(pName!="" && pPrice!="" && itemType!="" && pDesc!="" && imgName!=""){
        
    var r = confirm("Are you sure you want to update the item?");
    var data = {itemId: id, update: "yes", pName: pName, pPrice: pPrice, pType: itemType, pDesc: pDesc, pImage: imgName};
    if (r == true) {
        $.get("StoreControllerServlet", data, processResponseUpdate);
    }
    }else{
        $("#sp2").text("*Please enter all details").css({"color": "red", "font-size": 15});
    }
}
function processResponseUpdate(responseText) {
    $("#image").hide();
    $("#updateform").hide();
}
