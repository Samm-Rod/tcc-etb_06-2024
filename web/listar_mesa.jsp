<%-- 
    Document   : listar_mesa
    Created on : 31/05/2024, 22:24:19
    Author     : Root
--%>

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
        <title>Mesa crud</title>
        <script>
            
            function confirmarExclusao(id, numMesa){
                if(confirm('Deseja realmente remover a mesa '+numMesa+' ?')){
                    location.href='gerenciar_mesa.do?acao=deletar&id='+id;        
                }else{
                    alert('Não encontrado !')
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Lista de mesas</h1>
                    
            <a href="form_mesa.jsp" class="btn btn-primary">Novo Cadastro</a>       
            <table class="table table-hover table-striped table-bordered display" id="listarFuncionario">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Número da mesa</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Número da mesa</th>
                    </tr>
                </tfoot>
                
                <jsp:useBean class="dao.MesaDAO" id="mDAO"/>
                <tbody>
                    <c:forEach var="m" items = "${mDAO.lista}">
                <tr>
                    <td>${m.getId()}</td>
                    <td>${m.getNumMesa()}</td>
                    <td>
                        <a class="btn btn-primary" href="gerenciar_mesa.do?acao=alterar&id=${m.id}">
                            <i class="glyphicon glyphicon-pencil"></i>
                        </a>
                        <button class="btn btn-danger" onclick="confirmarExclusao('${m.id}','${m.numMesa}')">
                            <i class="glyphicon glyphicon-trash"></i>
                        </button>
                    </td>
                    
                </tr>
                </c:forEach>
                </tbody>
            </table>        
        </div>
        
    </body>
</html>
