<%@page import="dao.FuncionarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Funcionario"%>
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
        <title>Crud funcionário</title>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Cadastrar funcionário</h1>   
            <form action="gerenciar_funcionarios.do" method="POST">
                <input type="hidden" name="id" value="${funcionario.id}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome" class="control-label">Nome</label>
                        <input type="text" name="nome" class="form-control" id="nome" required="" value="${funcionario.nome}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="dataNasc" class="control-label">Data Nascimento</label>
                        <input type="date" name="dataNasc" class="form-control" id="dataNasc"  value="${funcionario.dataNasc}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="cpf" class="control-label">CPF</label>
                        <input type="text" name="cpf" class="form-control" id="cpf" required="" value="${funcionario.cpf}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="tel" class="control-label">Telefone</label>
                        <input type="text" name="tel" class="form-control" id="tel" required="" value="${funcionario.tel}"/>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="matricula" class="control-label">Matricula</label>
                        <input type="text" name="matricula" class="form-control" id="matricula" required="" value="${funcionario.matricula}"/>
                    </div>
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="senha" class="control-label">Senha</label>
                        <input type="password" name="senha" class="form-control" id="matricula" required="" value="${funcionario.senha}"/>
                    </div>
                </div>    
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <button class="btn btn-sucess">Cadastrar</button>
                        <a href="listar_funcionario.jsp" class="btn btn-warning">Voltar</a>
                    </div>
                </div>
                
            </form>           
        </div>
    </body>
</html>

