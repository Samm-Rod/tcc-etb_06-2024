/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Funcionario;

/**
 *
 * @author Root
 */
public class GerenciarFunLogin extends HttpServlet {

    private static HttpServletResponse response;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

        GerenciarFunLogin.response = response;
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        ArrayList<String> erros = new ArrayList<String>();
        
        if(matricula==null || matricula.trim().isEmpty()){
            erros.add("Preencha o login");
        }
        if(senha==null || senha.trim().isEmpty()){
            erros.add("Preencha a senha");
        }
        if(erros.size()>0){
            String campos = "";
            for(String erro : erros){
                campos = campos + "\\n"+erro;
            }
            exibirMensagem("Preencha os campo(s): "+campos);
        }else{
            try{
                FuncionarioDAO fDAO = new FuncionarioDAO();
                Funcionario f = new Funcionario();
                f = fDAO.getRecuperarFun(matricula);
                if(f.getId() > 0 && f.getSenha().equals(senha)){
                    HttpSession sessao = request.getSession();
                    response.sendRedirect("painelFun.jsp");
                }else{
                    exibirMensagem("Login ou senha inválido: ");
                }
            }catch(Exception e){
                exibirMensagem("Login ou senha inválido: ");

            }
            
        }
        
    }
    
    private static void exibirMensagem(String mensagem){
        try{
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("alert('"+mensagem+"')");
            out.print("history.back()");
            out.print("</script>");
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
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
