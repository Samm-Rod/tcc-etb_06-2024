/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import dao.ItemDAO;
import dao.PedidosDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import model.Item;
import model.Pedido;

/**
 *
 * @author SouthSystem
 */
public class GerenciarPedidos extends HttpServlet {

    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idI = request.getParameter("");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    String id = request.getParameter("id");
    String nome = request.getParameter("nome");
    String valor = request.getParameter("valor");
    String descricao = request.getParameter("descricao");
    String arqImg = request.getParameter("arqImg");

    String mensagem = "";
    Item i = new Item();
    Pedido p = new Pedido();
    Funcionario f = new Funcionario();
    try {

        ItemDAO iDAO = new ItemDAO();
        PedidosDAO  pDAO = new PedidosDAO();
        FuncionarioDAO fDAO = new FuncionarioDAO();
        if (nome == null || nome.isEmpty() || id == null || id.isEmpty() || valor == null || valor.isEmpty() || descricao == null || descricao.isEmpty()) {
            mensagem = "Campos obrigatórios faltando";
        } else {
            i.setId(Integer.parseInt(id));
            i.setNome(nome);
            i.setValor(Double.parseDouble(valor));
            i.setDescricao(descricao);
            i.setArqImg(arqImg);

            f = fDAO.getById(10); // id_funcionario
            p.setFuncionario(f);

            int novoIdPedido = pDAO.obterNovoIdPedido(); // Método para obter um novo ID de pedido
            p.setId(novoIdPedido);

            p.setItem(i);
            p.setValor(Double.parseDouble(valor));
            p.setNome(nome);
            p.setTotal(p.getValor() * p.getQtd()); // total

            if (pDAO.create(p)) {
                mensagem = "Pedido cadastrado com sucesso!";
            } else {
                mensagem = "Erro ao cadastrar pedido!";
            }
        }
    } catch (Exception e) {
        out.print(e.getMessage());
        mensagem = "Erro ao executar: " + e.getMessage();
        e.printStackTrace();
    }

    out.println("<script type='text/javascript'>"
            + "alert('" + mensagem + "');"
            + "location.href='card_pizza.jsp'"
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
