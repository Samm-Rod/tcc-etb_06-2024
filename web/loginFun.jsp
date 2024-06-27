<%-- 
    Document   : loginFun
    Created on : 20/06/2024, 18:45:26
    Author     : Root
--%>
<%@page import="dao.FuncionarioDAO"%>
<%@page import="dao.LoginAdmDAO"%>
<%@page import="model.Funcionario"%>
<%@page import="model.LoginAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="loginFun.css">
    <title>Login Page</title>
</head>

<body>
    <div class="container-page" id="Container">
        <div class="login-container" id="LoginContainer">
            
            <form action="gerenciar_login.do" method="POST">
                <h1 class="title">Login</h1>
                <div class="input-line-container">
                    <span class="name-input">Matricula:</span>
                    <input type="text" name="matricula" value="" class="input-line" id="matricula"  required=""/>
                </div>
                <div class="input-line-container">
                    <span class="name-input">Senha:</span>
                    <input type="password" name="senha"  value="" class="input-line" id="senha" required="" />
                    <i class="bi bi-person-fill-lock"></i>
                </div>
                    <button class="button-login">Login</button>
                    <a href="loginAdm.jsp" id="Register" class="button-second">Sou ADM</a>
            </form>
        </div>
    </div>
</body>

</html>
