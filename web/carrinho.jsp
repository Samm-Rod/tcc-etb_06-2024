<%-- 
    Document   : carrinho
    Created on : 17/06/2024, 19:30:11
    Author     : Root
--%>
<%@page import="dao.PedidosDAO"%>
<%@page import="dao.ItemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Pedido"%>
<%@page import="model.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrinho de Compras</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="carrinho.css" rel="stylesheet">
    <script src="carrinho.js"></script>
</head>
<body> 
<div class="container">
    <h2 class="text-center my-4">Carrinho</h2>
    <div class="card">
        <div class="card-header">Seu Carrinho</div>
        <div class="card-body">
            <jsp:useBean id="iDAO" class="dao.ItemDAO" scope="request" />
            <jsp:useBean id="pDAO" class="dao.PedidosDAO" scope="request" />
            
            <c:forEach var="c" items="${pDAO.allPedidos}">
                <div class="cart-item d-flex justify-content-between align-items-center" id="cart-item-${c.id}">
                    <img src="${pageContext.request.contextPath}/imagem/${c.getItem().getArqImg()}" style="width: 100px; height: 100px;"/> 
                    <div class="cart-item-info">
                        <div>
                            <span>${c.nome}</span>
                            <span class="mx-3">R$ ${c.valor}</span>
                        </div>
                    </div>
                    <div class="cart-item-actions">
                        <button class="btn btn-sm btn-info mr-2" onclick="alterarQuantidade('cart-item-${c.id}', -1)">-</button>
                        <span id="quantidade-${c.id}">${c.qtd}</span>
                        <button class="btn btn-sm btn-info ml-2" onclick="alterarQuantidade('cart-item-${c.id}', 1)">+</button>
                        <button class="btn btn-sm btn-excluir ml-3" onclick="excluirItem('cart-item-${c.id}')">Excluir</button>
                    </div>
                </div>
            </c:forEach>
                <c:forEach var="c" items="${pDAO.allPedidos}">
                    <div class="cart-total text-right my-3">
                        Total: R$ ${c.total}
                    </div>
                </c:forEach>
            
            <div class="cart-actions">
                <button class="btn btn-success" onclick="finalizarPedido()">Finalizar Pedido</button>
            </div>
        </div>
    </div>
</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
