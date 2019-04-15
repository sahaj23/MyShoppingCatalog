function addLink() {
    $("#image").hide();
    $("#addform").toggle();
    $("#updateform").hide();
    $("#deleteform").hide();
    $("#removeuserform").hide();
}
function updateLink() {  
    var data = {needId: "yes"};
    $("#id").load("StoreControllerServlet", data).append();
    var id = $("#id").val();
    $("#imageD").hide();
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
    $("#image").hide();
    $("#iddelete").val(id);
    $("#updateform").hide();
    $("#addform").hide();
    $("#deleteform").toggle();
    $("#deleteform").trigger("reset");
    $("#imageD").toggle();
    $("#imageD").hide();
    $("#removeuserform").hide();
}
function addProduct()
{
    var form = $('#addform')[0];
    var data = new FormData(form);
    alert(data);
    var pname=$("#pNameAdd").val();
    var ptype=$("#pTypeAdd").val();
    var pdesc=$("#pDescAdd").val();
    var pprice=$("#pPriceAdd").val();
    data.append("pname",pname);
    data.append("ptype",ptype);
    data.append("pdesc",pdesc);
    data.append("pprice",pprice);
    $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "AddNewProductControllerServlet",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                alert("Item added successfully");
                $("#addform").hide();

            },
            error: function (e) {

                alert("Item couldn't be added");
                
                

            }
        });
}
function updateProduct()
{
    var form = $('#updateform')[0];
    var data = new FormData(form);
    alert(data);
    var pname=$("#pName").val();
    var ptype=$("#pType").val();
    var pdesc=$("#pDesc").val();
    var pprice=$("#pPrice").val();
    var pid=$("#id").val();
    alert(pid);
    data.append("pname",pname);
    data.append("ptype",ptype);
    data.append("pdesc",pdesc);
    data.append("pprice",pprice);
    data.append("pid",pid);
    $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "UpdateProductControllerServlet",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                
                alert("Item updated successfully");
                $("#updateform").hide();

            },
            error: function (e) {
                
                alert("Item couldn't be updated"+e);
                
                

            }
        });
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

function processResponseUpdate(responseText) {
    $("#image").hide();
    $("#updateform").hide();
}
