<%-- 
    Document   : Cardapio
    Created on : 08/06/2024, 16:16:44
    Author     : SouthSystem
--%>
<%@page import="model.Pedido"%>
<%@page import="model.Item"%>
<%@page import="dao.PedidosDAO"%>
<%@page import="dao.ItemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estaticos/card_pizza.css">
        <script src="./cardapio.js"></script>
        <title>Cardápio Pizza</title>
        <style>
            #logo {
                text-decoration: none; /* Remove sublinhado */
                color: white; /* Define a cor do texto como branca */
            }
        </style>
        <script>
            
            function sendItem(id, valor, descricao, nome) {
                if (confirm('Item adicionado no carrinho!')) {
                    location.href = 'gerenciar_pedidos.do?acao=carrinho&id='+ id +'&valor=' + valor +'&descricao='+descricao+'&nome=' + nome;
                } else {
                    alert('Não encontrado!');
                }
            }
        </script>

    </head>
    <body>
        <header>
                <h1><a href="index.jsp" id="logo">Cardápio Digital</a></h1>
        </header>

        <nav>
            <ul>
                <li><a href="card_pizza.jsp" onclick="showTab('pizzas')">Pizzas</a></li>
                <li><a href="card_hamburguer.jsp" onclick="showTab('hamburgers')">Hambúrgueres</a></li>
                <li><a href="card_pratos.jsp" onclick="showTab('pratos')">Pratos</a></li>
                <li><a href="card_drinks.jsp" onclick="showTab('chopes')">Bebidas</a></li>
                <li><a href="carrinho.jsp" onclick="showTab('carrinho')">Carrinho</a></li>
            </ul>
        </nav>

        <main>
            <jsp:useBean class="dao.PedidosDAO" id="pDAO"/>
            <jsp:useBean class="dao.ItemDAO" id="iDAO"/>
            <tbody>
                <c:forEach var="i" items="${iDAO.allPizza}">
                <form action="gerenciar_pedidos.do" method="POST">
                    <input type="hidden" name="id" value="${i.getId()}"/>
                    <section id="pizzas" class="tab-content active">
                        <div class="item">
                            <h3>${i.getNome()}</h3>
                            <div class="item-content">
                                <div class="text">
                                    <p>Preço: R$ ${i.getValor()}</p>
                                    <p>Ingredientes: ${i.getDescricao()}</p>
                                    <input type="hidden" name="nome" value="${i.getNome()}"/>
                                    <input type="hidden" name="valor" value="${i.getValor()}"/>
                                    <input type="hidden" name="descricao" value="${i.getDescricao()}"/>
                                    <input type="hidden" name="arqImg" value="${i.getArqImg()}"/>
                                    <button onclick="sendItem('${i.id}','${i.valor}','${i.descricao}','${i.nome}')" type="submit">Add cart</button>
                                </div>
                                <div class="image">
                                    <img src="${pageContext.request.contextPath}/imagem/${i.getArqImg()}" style="width: 100px; height: 100px;"/>
                                </div>
                            </div>
                        </div>
                    </section>
                </form>
            </c:forEach>
            </tbody>
        </main>
            

    </body>
</html>
