<%@page import="dao.MesaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Mesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css">
        <link rel="stylesheet" href="datatables/datatables.min.css">
        <title>Cadastrar Mesas</title>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Cadastrar Mesa</h1>   
            <form action="gerenciar_mesa.do" method="POST">
                <input type="hidden" name="id" value="${mesa.id}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="numMesa" class="control-label">Número da mesa</label>
                        <input type="text" name="numMesa" class="form-control" id="numMesa" required="" value="${mesa.numMesa}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <button class="btn btn-sucess">Cadastrar</button>
                        <a href="listar_mesa.jsp" class="btn btn-warning">Voltar</a>
                    </div>
                </div>
                
            </form>           
        </div>
    </body>
</html>
