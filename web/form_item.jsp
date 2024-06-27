<%-- 
    Document   : form_item
    Created on : 01/06/2024, 19:59:01
    Author     : Root
--%>

<%@page import="dao.ItemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
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
        <title>Crud Item</title>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Cadastrar Item</h1>   
            <form action="gerenciar_item.do" method="POST">
                <input type="hidden" name="id" value="${item.id}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome" class="control-label">Nome</label>
                        <input type="text" name="nome" placeholder="Pizza de calabresa"  class="form-control" id="nome" required="" value="${item.nome}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="valor" class="control-label">Valor</label>
                        <input type="text" name="valor" placeholder="R$ 35.50" class="form-control" id="valor"  value="${item.valor}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="descricao" class="control-label">Descricao</label>
                        <input type="text" name="descricao" placeholder="calabresa, cebola, queijo" class="form-control" id="descricao" required="" value="${item.descricao}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="arqImg" class="control-label">Imagem</label>
                        <input type="file" name="arqImg" class="form-control" id="arqImg" required="" value="${item.arqImg}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <button class="btn btn-sucess">Cadastrar</button>
                        <a href="listar_item.jsp" class="btn btn-warning">Voltar</a>
                    </div>
                </div>
                
            </form>           
        </div>
    </body>
</html>