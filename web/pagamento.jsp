<%-- 
    Document   : pagamento
    Created on : 17/06/2024, 19:32:38
    Author     : Root
--%>
<%@page import="dao.PedidosDAO"%>
<%@page import="dao.MesaDAO"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="dao.PagamentosDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Pagamentos"%>
<%@page import="model.Cliente"%>
<%@page import="model.Pedido"%>
<%@page import="model.Mesa"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagamento</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .cart-summary {
            margin-bottom: 20px;
        }
        .payment-options label {
            margin-right: 15px;
        }
        .confirmation-message {
            display: none;
            margin-top: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center my-4">Informações de Pagamento</h2>
        <c:forEach var="c" items="${pDAO.allPedidos}">
            <div class="cart-summary mb-4" id="cart-summary">
                <input type="hidden" value="${c.total}"/>
            </div>
        </c:forEach>
        </div>
            <form action="card_pizza.jsp" method="post">
        <div class="form-container">
            <form id="payment-form" onsubmit="concluirPagamento(event)">
                <div class="form-group">
                    <label for="cpf">CPF:</label>
                    <input type="text" value="${cliente.cpf}" class="form-control" id="cpf" name="cpf" placeholder="000.000.000-00" maxlength="14" required oninput="mascaraCPF(this)">
                </div>
                <div class="form-group">
                    <label for="mesa">Número da Mesa:</label>
                    <input type="number" class="form-control" value="${mesa.numMesa}" id="mesa" name="mesa" placeholder="Ex 1" min="1" max="100" required>
                </div>
                <div class="form-group">
                    <label>Forma de Pagamento:</label>
                    <div class="payment-options">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" value="${pagamento.tipoPag}" type="radio" name="formaPagamento" id="dinheiro" value="dinheiro" required>
                            <label class="form-check-label"  for="dinheiro">Dinheiro</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" value="${pagamento.tipoPag}" type="radio" name="formaPagamento" id="pix" value="pix">
                            <label class="form-check-label" for="pix">Pix</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" value="${pagamento.tipoPag}" type="radio" name="formaPagamento" id="debito" value="debito">
                            <label class="form-check-label" for="debito">Débito</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" value="${pagamento.tipoPag}" type="radio" name="formaPagamento" id="credito" value="credito">
                            <label class="form-check-label" for="credito">Crédito</label>
                        </div>
                    </div>
                </div>
                <div class="payment-actions text-right">
                    
                    <button type="submit" class="btn btn-primary">Concluir</button>
                    
                </div>
            </form>
            <div id="confirmation-message" class="alert alert-success confirmation-message">
                Pedido finalizado com sucesso!
            </div>
        </div>
    </form>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const cartSummaryElement = document.getElementById('cart-summary');
            const cartData = JSON.parse(localStorage.getItem('cartData')) || [];

            if (cartData.length > 0) {
                cartData.forEach(item => {
                    const div = document.createElement('div');
                    div.className = 'd-flex justify-content-between';
                    div.textContent = '${item.item} - R$ ${item.price}';
                    cartSummaryElement.appendChild(div);
                });

                const total = cartData.reduce((sum, item) => sum + parseFloat(item.price), 0);
                const totalDiv = document.createElement('div');
                totalDiv.className = 'font-weight-bold text-right mt-3';
                totalDiv.textContent = 'Total: R$ ${total.toFixed(2)}';
                cartSummaryElement.appendChild(totalDiv);
            } else {
                cartSummaryElement.textContent = 'Carrinho vazio.';
            }
        });

        function mascaraCPF(input) {
            const value = input.value.replace(/\D/g, '');
            if (value.length <= 11) {
                input.value = value
                    .replace(/(\d{3})(\d)/, '$1.$2')
                    .replace(/(\d{3})(\d)/, '$1.$2')
                    .replace(/(\d{3})(\d{1,2})$/, '$1-$2');
            }
        }

        function concluirPagamento(event) {
            event.preventDefault();
            const cpf = document.getElementById('cpf').value;
            const mesa = document.getElementById('mesa').value;
            const formaPagamento = document.querySelector('input[name="formaPagamento"]:checked').value;

            if (cpf && mesa && formaPagamento) {
                document.getElementById('payment-form').style.display = 'none';
                const confirmationMessage = document.getElementById('confirmation-message');
                confirmationMessage.style.display = 'block';
                localStorage.removeItem('cartData');
            } else {
                alert('Por favor, preencha todos os campos.');
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

