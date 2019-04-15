<%@page import="shoppingcatalog.dto.ItemDTO"%>
<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <title>Admin Access</title>
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css" >
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="scripts/jquery.js">
        </script>
        <script type="text/javascript" src="scripts/adminoptions.js"></script>
        <script type="text/javascript" src="scripts/forms.js"></script>


    </head>
    <body >
        <div id="logo">

            <img src="images/shopping_logo5.png" >
        </div>
        <h1>Admin Options</h1>
        <p>Please select a category you want to update:</p>

        <%
            HttpSession sess = request.getSession();
            if (sess.getAttribute("username") == null) {
                sess.invalidate();
                response.sendRedirect("accessdenied.html");

            }

            out.println("<ul style='list-style-type:none'>");
            out.println("<li><a href='#'  onclick='expand(this)' id='Products'>+Products</a>");
            out.println("<ul style='display:none;margin-left: 10px'  id='ProductsList'  >");
            out.println("<li><a href='#' onclick='addLink()'>Add</a></li>"
                    + "<li><a href='#' onclick='updateLink()'>Update</a></li>"
                    + "<li><a href='#' onclick='deleteLink()'>Delete</a></li></ul>");
            out.println("</li><li><a href='#'  onclick='expand(this)' id='Users'>+Users</a>"
                    + "<ul style='display:none' id='UsersList'>"
                    + "<li><a href='#' onclick='callName()'>Remove</a></li> </ul></li>");
            out.println("<li><a href='#'  onclick='expand(this)' id='View'>+View</a>"
                    + "<ul style='display:none' id='ViewList'>"
                    + "<li><a href='adminorders.jsp'>Orders</a></li></ul></li>");
            out.println("</ul>");
            out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
            out.println("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");

        %>


        <form id="addform" class="forms">
            <p class="formtitle">Add Item</p>
            <div align='center'>
                <p><b>Product Name:</b> <input type="text" name="productName" id="pNameAdd" ></p>
                <p><b>Product Type: </b><input type="text" name="productType" id="pTypeAdd"></p>
                <p><b>Product Price: </b><input type="text" name="productPrice" id="pPriceAdd"></p>
                <p><b>Product Desc: </b><input type="text" name="productDesc" id="pDescAdd"></p>
                <p> <input type="file" name="productImage" accept="image/*" id="pImageAdd"></p>

                <button type="button" id="addproduct" onclick="add()">Add Product</button>
                <button type="button" id="clear" onclick="clearForm('addform')">Clear</button>
            </div>
        </form>
        <form id='updateform' class="forms">
            <p class="formtitle">Update Item</p>
            <div align='center'>
                <p><b>Product ID:</b> <select onchange="update()" id="id"></select></p>
                <p><b>Product Name:</b> <input type="text" name="productName" id="pName"></p>
                <p><b>Product Type: </b><input type="text" name="productType" id="pType"></p>
                <p><b>Product Price: </b><input type="text" name="productPrice" id="pPrice"></p>
                <p><b>Product Desc: </b><input type="text" name="productDesc" id="pDesc"></p>
                <p> <input type="file" name="productImage" accept="image/*" onchange="changePic(this)"id="pImage"></p>

                <button type="button" id="updateproduct" onclick="updateProduct()">Update Product</button>
                <button type="button" id="clear" onclick="clearForm('updateform')" >Clear</button>
                <span id="sp2"></span>
            </div>
        </form>
        <img id='image'>

        <form id='deleteform' name="delete" class="forms">
            <p class="formtitle">Delete Item</p>
            <div align='center'>
                <p><b>Product ID:</b> <select onchange="deletef()" id="iddelete"> </select></p>
                <p><b>Product Name:</b> <input type="text" name="productName" id="pNameD"></p>
                <p><b>Product Type: </b><input type="text" name="productType" id="pTypeD"></p>
                <p><b>Product Price: </b><input type="text" name="productPrice" id="pPriceD"></p>
                <p><b>Product Desc: </b><input type="text" name="productDesc" id="pDescD"></p>
                <button type="button" id="deleteproduct" onclick="deleteProduct()">Delete Product</button>

            </div>
        </form>
        <img id='imageD'>
        <form id="removeuserform" class='forms'>
             <p class="formtitle">Remove User</p>
             <div align='center'>
                 <p> <select id='usernames'></select><p>
                     <button type="button" id="removeuserbtn" onclick="removeUser()">Remove User</button>
             </div>
        </form>
    </body>
</html>