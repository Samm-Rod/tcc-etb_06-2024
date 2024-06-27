<%-- 
    Document   : index
    Created on : 14/05/2024, 04:56:25
    Author     : Root
--%>

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
        <title>Funcionário crud</title>
        <script>
            
            function confirmarExclusao(id, nome, dataNasc, cpf, tel, matricula, senha){
                if(confirm('Deseja realmente excluir o funcionário '+nome+' ?')){
                    location.href='gerenciar_funcionarios.do?acao=deletar&id='+id;        
                }else{
                    alert('Não encontrado !')
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp"%>
            <h1>Lista de funcionários</h1>
                    
            <a href="form_funcionario.jsp" class="btn btn-primary">Novo Cadastro</a>       
            <table class="table table-hover table-striped table-bordered display" id="listarFuncionario">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data Nascimento</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Matricula</th>
                        <th>Senha</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data Nascimento</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Matricula</th>
                        <th>Senha</th>
                    </tr>
                </tfoot>
                
                <jsp:useBean class="dao.FuncionarioDAO" id="fDAO"/>
                <tbody>
                <c:forEach var="f" items = "${fDAO.lista}">
                <tr>
                    <td>${f.getId()}</td>
                    <td>${f.getNome()}</td>
                    <td>${f.getDataNasc()}</td>
                    <td>${f.getCpf()}</td>
                    <td>${f.getTel()}</td>
                    <td>${f.getMatricula()}</td>
                    <td>${f.getSenha()}</td>
                    <td>
                        <a class="btn btn-primary" href="gerenciar_funcionarios.do?acao=alterar&id=${f.id}">
                            <i class="glyphicon glyphicon-pencil"></i>
                        </a>
                        <button class="btn btn-danger" onclick="confirmarExclusao('${f.id}','${f.nome}','${f.dataNasc}','${f.cpf}','${f.tel}','${f.matricula}','${f.senha}')">
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
