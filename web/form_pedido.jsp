<%-- 
    Document   : form_pedido
    Created on : 08/06/2024, 15:37:27
    Author     : SouthSystem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Cadastrar Mesa</h1>   
            <form action="gerenciar_pedido.do" method="POST">
                <input type="hidden" name="id" value="${pedido.id}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="qtd" class="control-label">Quantidade</label>
                        <input type="text" name="qtd" class="form-control" id="qtd" required="" value="${pedido.qtd}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <button class="btn btn-sucess">Cadastrar</button>
                        <a href="listar_pedido.jsp" class="btn btn-warning">Voltar</a>
                    </div>
                </div>
                
            </form>           
        </div>
    </body>
</html>
