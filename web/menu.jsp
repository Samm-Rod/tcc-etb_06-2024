<div class="menu">
    <ul>
        <li><a href="index.jsp">Início</a></li>
        <li><a href="listar_funcionario.jsp">Funcionarios</a></li>
        <li><a href="card_pizza.jsp">Cardápio</a></li>
        <li><a href="listar_item.jsp">Produtos</a></li>
        <li><a href="carrinho.jsp">Pedidos</a></li>
        <li><a href="listar_mesa.jsp">Mesas</a></li>
    </ul>
</div>
<style>
    .menu {
    width: 100%;
    background-color: #333;
    overflow: hidden;
}

.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
}

.menu ul li {
    display: inline;
}

.menu ul li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 20px;
    text-decoration: none;
    transition: background-color 0.3s;
}

.menu ul li a:hover {
    background-color: #111;
}

/* Responsivo */
@media (max-width: 600px) {
    .menu ul {
        flex-direction: column;
        width: 100%;
    }

    .menu ul li {
        width: 100%;
    }
}
</style>
<link rel="stylesheet" href="estilo/menu.css" type="text/css"/>
