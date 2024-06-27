<%-- 
    Document   : listar_pagamento
    Created on : 18/06/2024, 13:46:29
    Author     : Root
--%>

<%@page import="dao.PagamentosDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Pagamentos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="pagamentos.css">
        <title>Lista de Pedidos</title>
    </head>
    <body>
        <div id="pedidos-container" class="container">
            <h2 class="text-center my-4">Lista de Pedidos</h2>
            <table id="pedidosTable" class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>CPF</th>
                        <th>Número da Mesa</th>
                        <th>Pedido</th>
                        <th>Forma de Pagamento</th>
                        <th>Valor Total</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody id="tableBody">
                    <jsp:useBean class="dao.PagamentosDAO" id="pgDAO"/>
                    <c:forEach var="p" items="${pgDAO.allPagamentos}">
                        <tr>
                            <td data-label="ID">${p.id}</td>
                            <td data-label="CPF">${p.cpf}</td>
                            <td data-label="Número da Mesa">${p.mesa}</td>
                            <td data-label="Pedido">${p.pedido}</td>
                            <td data-label="Forma de Pagamento">${p.pagamento}</td>
                            <td data-label="Valor Total">${p.total.toFixed(2)}</td>
                            <td data-label="Ações">
                                <button class="btn btn-warning btn-sm"><i class="fas fa-edit"></i></button>
                                <button class="btn btn-danger btn-sm"><i class="fas fa-trash"></i></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="pagamentos.js"></script>
    </body>
</html>
