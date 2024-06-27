<%-- 
    Document   : listar_item
    Created on : 01/06/2024, 20:57:28
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
        <title>Item crud</title>
        <script>
            
            function confirmarExclusao(id, nome, valor, descricao, arqImg){
                if(confirm('Deseja realmente excluir esse item '+nome+' ?')){
                    location.href='gerenciar_item.do?acao=deletar&id='+id;        
                }else{
                    alert('Não encontrado !')
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Lista de item</h1>
                    
            <a href="form_item.jsp" class="btn btn-primary">Novo Cadastro</a>       
            <table class="table table-hover table-striped table-bordered display" id="listarFuncionario">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Valor R$</th>
                        <th>Descrição</th>
                        <th>Imagem</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Valor R$</th>
                        <th>Descrição</th>
                        <th>Imagem</th>
                    </tr>
                </tfoot>
                
                <jsp:useBean class="dao.ItemDAO" id="iDAO"/>
                <tbody>
                    <c:forEach var="i" items="${iDAO.lista}">
                <tr>
                    <td>${i.getId()}</td>
                    <td>${i.getNome()}</td>
                    <td>R$ ${i.getValor()}</td>
                    <td> ${i.getDescricao()}</td>
                    <td><img src="${pageContext.request.contextPath}/imagem/${i.arqImg}" style="width: 100px; height: 100px; "/></td>
                    
                    <td>
                        <a class="btn btn-primary" href="gerenciar_item.do?acao=alterar&id=${i.id}">
                            <i class="glyphicon glyphicon-pencil"></i>
                        </a>
                        <button class="btn btn-danger" onclick="confirmarExclusao('${i.id}','${i.nome}','${i.valor}','${i.descricao}','${i.arqImg}')">
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
