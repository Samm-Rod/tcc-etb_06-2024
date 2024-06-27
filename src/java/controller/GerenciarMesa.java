/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MesaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mesa;

/**
 *
 * @author Root
 */
public class GerenciarMesa extends HttpServlet {

    

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
        
        PrintWriter out = response.getWriter();
        String mensagem = "";
        
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        String numMesa = request.getParameter("numMesa");
        
        Mesa m = new Mesa();
        
        try{
            
            MesaDAO mDAO = new MesaDAO();
            if(acao.equals("alterar")){
                m = mDAO.getCarregaPorId(Integer.parseInt(id));
                if(m.getId() > 0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_mesa.jsp");
                    request.setAttribute("mesa", m);
                    disp.forward(request, response);
                }else{
                    mensagem = "Mesa não encontrado";
                }
            } 
            
            if(acao.equals("deletar")){
                m.setId(Integer.parseInt(id));
                if(mDAO.deletar(m)){
                    mensagem = "Mesa removida do sistema !";
                }else{
                    mensagem = "Erro ao remover a mesa !";
                }
            }
            
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar";
        }
        out.println("<script type='text/javascript'>"
                        + "alert('" + mensagem + "');"
                        + "location.href='listar_mesa.jsp'"
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
        String numMesa = request.getParameter("numMesa");
        
        String mensagem = "";
        Mesa m = new Mesa();
        try{
            
            MesaDAO mDAO = new MesaDAO();
            
            if (numMesa == null || numMesa.isEmpty()){
                mensagem = "Campos obrigatorios";
            }else{
                m.setNumMesa(Integer.parseInt(numMesa));

                if (!id.isEmpty()) {
                    try {
                        m.setId(Integer.parseInt(id));
                        
                        if (mDAO.gravar(m)) {
                            mensagem = "Mesa cadastrada com sucesso !";
                        }else{
                            mensagem = "Erro ao cadastrar mesa!";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "ID inválido!";
                    }
                } else {
                    m.setNumMesa(Integer.parseInt(numMesa));
                   
                    if (!mDAO.gravar(m)) {
                        mensagem = "Erro ao cadastrar uma nova mesa!";
                    } else {
                        mensagem = "Mesa cadastrada com sucesso!";
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
                        + "location.href='listar_mesa.jsp'"
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
