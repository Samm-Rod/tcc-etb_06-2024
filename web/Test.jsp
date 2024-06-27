<%-- 
    Document   : Test
    Created on : 24/06/2024, 03:53:18
    Author     : Root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="script.js"></script>
    </head>
    <body>
        <h2>Array com JavaScript</h2>
        <label>Informe valor: </label><br>
        <input id="v"/><br>
        <button onclick="addItem()">Add</button>
        <button onclick="showItems()">Show</button>
        <button onclick="clearItems()">Clear</button>
        <div id="d"></div>
    </body>
</html>
