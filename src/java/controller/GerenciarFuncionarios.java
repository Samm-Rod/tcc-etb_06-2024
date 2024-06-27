/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import dao.FuncionarioDAO;

/**
 *
 * @author Root
 */
public class GerenciarFuncionarios extends HttpServlet {



    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem = "";
        
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");
        String cpf = request.getParameter("cpf");
        String tel = request.getParameter("tel");
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        Funcionario f = new Funcionario();
        
        try{
            
            FuncionarioDAO fDAO = new FuncionarioDAO();
            if(acao.equals("alterar")){
                f = fDAO.getById(Integer.parseInt(id));
                if(f.getId() > 0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_funcionario.jsp");
                    request.setAttribute("funcionario", f);
                    disp.forward(request, response);
                }else{
                    mensagem = "Funcionário não encontrado";
                }
            } 
            
            if(acao.equals("deletar")){
                f.setId(Integer.parseInt(id));
                if(fDAO.deletar(f)){
                    mensagem = "Funcionário deletado com sucesso !";
                }else{
                    mensagem = "Erro ao excluir o funcionário !";
                }
            }
            
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar";
        }
        out.println("<script type='text/javascript'>"
                        + "alert('" + mensagem + "');"
                        + "location.href='listar_funcionario.jsp'"
                        + "</script>");
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");
        String cpf = request.getParameter("cpf");
        String tel = request.getParameter("tel");
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        String mensagem = "";
        Funcionario f = new Funcionario();
        try{
            
            FuncionarioDAO fDAO = new FuncionarioDAO();
            
            if (nome == null || nome.isEmpty()){
                mensagem = "Campos obrigatorios";
            }else{
                f.setNome(nome);

                if (!id.isEmpty()) {
                    try {
                        f.setId(Integer.parseInt(id));
                        f.setDataNasc(Date.valueOf(dataNasc));
                        f.setCpf(cpf);
                        f.setTel(tel);
                        f.setMatricula(matricula);
                        f.setSenha(senha);
                        if (fDAO.gravar(f)) {
                            mensagem = "Funcionario gravado com sucesso !";
                        }else{
                            mensagem = "Erro ao atualizar funcionário!";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "ID inválido!";
                    }
                } else {
                    f.setDataNasc(Date.valueOf(dataNasc));
                    f.setCpf(cpf);
                    f.setTel(tel);
                    f.setMatricula(matricula);
                    f.setSenha(senha);
                    if (!fDAO.gravar(f)) {
                        mensagem = "Erro ao gravar funcionário!";
                    } else {
                        mensagem = "Funcionário cadastrado com sucesso!";
                    }
                }
                
            }
        }catch(Exception e){
            out.print(e.getMessage());
            mensagem = "Erro ao executar";
            e.printStackTrace();
        }
        
        out.println("<script type='text/javascript'>"
                        + "alert('" + mensagem + "');"
                        + "location.href='listar_funcionario.jsp'"
                        + "</script>");
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
