<%-- 
    Document   : listar_pedido
    Created on : 08/06/2024, 15:42:24
    Author     : SouthSystem
--%>
<%@page import="dao.PedidosDAO"%>
<%@page import="dao.ItemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
<%@page import="model.Pedido"%>
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
                    
            <a href="form_pedido.jsp" class="btn btn-primary">Novo Cadastro</a>       
            <table class="table table-hover table-striped table-bordered display" id="listarFuncionario">
                <thead>
                    <tr>
                        
                        <th>Nome</th>
                        <th>Valor R$</th>
                        <th>Quantidade</th>
                        <th>Imagem</th>
                        
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th>Valor R$</th>
                        <th>Quantidade</th>
                        <th>Imagem</th>
                        
                    </tr>
                </tfoot>
                <jsp:useBean class="dao.ItemDAO" id="iDAO"/>
                <jsp:useBean class="dao.PedidosDAO" id="pDAO"/>
                <c:forEach var="p" items="${pDAO.lista}">
                <tbody>
                    
                <tr>
                    <td>${pedido.getId()}</td>
                    <td>${pedido.getNome()}</td>
                    <td>${item.getValor()}</td>
                    <td><img src="${pageContext.request.contextPath}/imagem/${item.arqImg}" style="width: 100px; height: 100px; "/></td>
                    <td>${pedido.getQtd()}</td>
                    
                    <td>
                        <a class="btn btn-primary" href="gerenciar_item.do?acao=alterar&id=${i.id}">
                            <i class="glyphicon glyphicon-pencil"></i>
                        </a>
                        <button class="btn btn-danger" onclick="confirmarExclusao('${i.id}','${i.nome}','${i.valor}','${i.descricao}','${i.arqImg}')">
                            <i class="glyphicon glyphicon-trash"></i>
                        </button>
                    </td>
                    
                </tr>
                
                </tbody>
                </c:forEach>
            </table>        
        </div>
        
    </body>
</html>

