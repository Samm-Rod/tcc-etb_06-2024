/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemDAO;
import dao.PedidosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Item;


/**
 *
 * @author Root
 */
public class GerenciarItem extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
    
    PrintWriter out = response.getWriter();
    String mensagem = "";
    
    String acao = request.getParameter("acao");
    String id = request.getParameter("id");
    String nome = request.getParameter("nome");
    String valor = request.getParameter("valor");
    String descricao = request.getParameter("descricao");
    String arqImg = request.getParameter("arqImg");
    
    Item i = new Item();
    double totalPag;
    double vl = 0.0;
    
    // Verifica se o valor não é nulo antes de tentar convertê-lo
    if (valor != null) {
        try {
            vl = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            mensagem = "Valor inválido";
            out.println("<script type='text/javascript'>"
                    + "alert('" + mensagem + "');"
                    + "location.href='card_pizza.jsp'"
                    + "</script>");
            return;
        }
    } else {
        mensagem = "Valor está nulo"+valor;
        out.println("<script type='text/javascript'>"
                + "alert('" + mensagem + "');"
                + "location.href='card_pizza.jsp'"
                + "</script>");
        return;
    }
    
    try {
        ArrayList<Carrinho> lista = new ArrayList<>();
        ItemDAO iDAO = new ItemDAO();
        if (acao != null) {
            if (acao.equals("alterar")) {
                if (id != null) {
                    i = iDAO.getCarregaPorId(Integer.parseInt(id));
                    if (i.getId() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_item.jsp");
                        request.setAttribute("item", i);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Item não encontrado";
                    }
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("deletar")) {
                if (id != null) {
                    i.setId(Integer.parseInt(id));
                    if (iDAO.deletar(i)) {
                        mensagem = "Item deletado com sucesso!";
                    } else {
                        mensagem = "Erro ao excluir o item!";
                    }
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("carrinho")) {
                int item = 0;
                int qtd = 1;
                if (id != null) {
                    int idI = Integer.parseInt(id);
                    i = iDAO.getByIdItem(idI);
                    item++;
                    Carrinho c = new Carrinho();
                    
                    c.setId(item);
                    c.setIdItem(i.getId());
                    c.setNome(nome);
                    c.setValor(vl);
                    c.setDescricao(descricao);
                    c.setArqImg(arqImg);
                    c.setQtd(qtd);
                    c.setTotal(qtd * c.getValor());
                    lista.add(c);
                    request.setAttribute("count", lista.size());
                    request.getRequestDispatcher("card_pizza.jsp").forward(request, response);
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("carPage")) {
                totalPag = 0.0;
                request.setAttribute("carPage", lista);
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }
        } else {
            mensagem = "Ação inválida";
        }
    } catch (Exception e) {
        out.print(e);
        mensagem = "Erro ao executar";
    }
    out.println("<script type='text/javascript'>"
            + "alert('" + mensagem + "');"
            + "location.href='card_pizza.jsp'"
            + "</script>");
    }
        
    
    

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
    String nome = request.getParameter("nome");
    String valor = request.getParameter("valor");
    String descricao = request.getParameter("descricao");
    String arqImg = request.getParameter("arqImg");
    
    Item i = new Item();
    double totalPag;
    double vl = 0.0;
    
    
    try {
        ArrayList<Carrinho> lista = new ArrayList<>();
        ItemDAO iDAO = new ItemDAO();
        if (acao != null) {
            if (acao.equals("alterar")) {
                if (id != null) {
                    i = iDAO.getCarregaPorId(Integer.parseInt(id));
                    if (i.getId() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_item.jsp");
                        request.setAttribute("item", i);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Item não encontrado";
                    }
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("deletar")) {
                if (id != null) {
                    i.setId(Integer.parseInt(id));
                    if (iDAO.deletar(i)) {
                        mensagem = "Item deletado com sucesso!";
                    } else {
                        mensagem = "Erro ao excluir o item!";
                    }
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("carrinho")) {
                int item = 0;
                int qtd = 1;
                if (id != null) {
                    int idI = Integer.parseInt(id);
                    i = iDAO.getByIdItem(idI);
                    item++;
                    Carrinho c = new Carrinho();
                    
                    c.setId(item);
                    c.setIdItem(i.getId());
                    c.setNome(nome);
                    c.setValor(vl);
                    c.setDescricao(descricao);
                    c.setArqImg(arqImg);
                    c.setQtd(qtd);
                    c.setTotal(qtd * c.getValor());
                    lista.add(c);
                    request.setAttribute("count", lista.size());
                    request.getRequestDispatcher("card_pizza.jsp").forward(request, response);
                } else {
                    mensagem = "ID do item é inválido";
                }
            }
            
            if (acao.equals("carPage")) {
                totalPag = 0.0;
                request.setAttribute("carPage", lista);
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }
        } else {
            mensagem = "Ação inválida";
        }
    } catch (Exception e) {
        out.print(e);
        mensagem = "Erro ao executar";
    }
    out.println("<script type='text/javascript'>"
            + "alert('" + mensagem + "');"
            + "location.href='card_pizza.jsp'"
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
        String valor = request.getParameter("valor");
        String descricao = request.getParameter("descricao");
        String arqImg = request.getParameter("arqImg");
        
        String mensagem = "";
        Item i = new Item();
        try{
            
            ItemDAO iDAO = new ItemDAO();
        
            if (nome == null || nome.isEmpty()){
                mensagem = "Campos obrigatorios";
            }else{
                i.setNome(nome);

                if (!id.isEmpty()) {
                    try {
                        i.setId(Integer.parseInt(id));
                        double nValor = 0;
                        if(!valor.isEmpty()){
                            nValor = Double.parseDouble(valor.replace(".","").replace(",","."));
                        }
                        i.setValor(nValor);
                        i.setDescricao(descricao);
                        i.setArqImg(arqImg);
                        if (iDAO.gravar(i)) {
                            mensagem = "Item cadastrado com sucesso !";
                        }else{
                            mensagem = "Erro ao atualizar item !";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "ID inválido!";
                    }
                } else {
                    i.setValor(Double.parseDouble(valor));
                    i.setDescricao(descricao);
                    i.setArqImg(arqImg);

                    if (!iDAO.gravar(i)) {
                        mensagem = "Erro ao gravar um item !";
                    } else {
                        mensagem = "Item cadastrado com sucesso!";
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
                        + "location.href='listar_item.jsp'"
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
