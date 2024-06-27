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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import model.Item;
import model.Pagamentos;
import model.Pedido;

/**
 *
 * @author Root
 */
public class GerenciarPagamento extends HttpServlet {


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

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String cpf = request.getParameter("cpf");
        String valor = request.getParameter("valor");
        String numMesa = request.getParameter("numMesa");
        String tipoPag = request.getParameter("tipoPag");


        String mensagem = "";
        Item i = new Item();
        Pedido p = new Pedido();
        Funcionario f = new Funcionario();
        Cliente c = new Cliente();
        try {

            ItemDAO iDAO = new ItemDAO();
            PedidosDAO  pDAO = new PedidosDAO();
            FuncionarioDAO fDAO = new FuncionarioDAO();
            Pagamentos pg = new Pagamentos();
            if (cpf == null || cpf.isEmpty()) {
                mensagem = "Campos obrigatorios";
            } else {
                c.setCpf(cpf);
                pg.setCliente(c);

                if (!id.isEmpty()) {
                    try {
                        f = fDAO.getById(10);// id_funcionario
                        p.setFuncionario(f);
                        int x = 0;
                        x++;
                        p.setId(x); // id_pedidos
                        i.setId(Integer.parseInt(id)); 
                        p.setItem(i); // id_item
                        p.setValor(Double.parseDouble(valor)); // valor
                        //p.setNome(nome); // nome
                        p.setTotal(p.getValor() * p.getQtd()); // total
                        //i.setArqImg(arqImg); // imagem

                        p.setItem(i);

                        if (pDAO.gravar(p)) {
                            mensagem = "Pedido cadastrado com sucesso !";
                        } else {
                            mensagem = "Erro ao atualizar pedido !";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "ID inválido!";
                    }
                } else {

                    i.setId(Integer.parseInt(id)); 
                    p.setItem(i); // id_item
                    p.setValor(Double.parseDouble(valor)); // valor
                    //p.setNome(nome); // nome
                    //i.setArqImg(arqImg);
                    p.setItem(i);
                    if (!pDAO.gravar(p)) {
                        mensagem = "Erro ao gravar um Pedido !";
                    } else {
                        mensagem = "Pedido cadastrado com sucesso!";
                    }
                }

            }
        } catch (Exception e) {
            out.print(e.getMessage());
            mensagem = "Erro ao executar";
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
