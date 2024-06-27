<%-- 
    Document   : loginAdm
    Created on : 20/06/2024, 18:43:29
    Author     : Root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="loginAdm.css">

    <title>Login ADM</title>
</head>

<body>
    <div class="container-page" id="Container">
        <div class="login-container" id="LoginContainer">
            <h1 class="title">Login</h1>
            <form action="">
                <div class="input-line-container">
                    <span class="name-input">Matricula:</span>
                    <input type="text" name="matricula" class="input-line" id="">
                </div>
                <div class="input-line-container">
                    <span class="name-input">Senha:</span>
                    <input type="password" name="senha" class="input-line" id="" />
                    <i class="bi bi-person-fill-lock"></i>
                </div>
                <input type="button" value="Login" class="button-login">
            </form>
        </div>
    </div>
</body>

</html>
