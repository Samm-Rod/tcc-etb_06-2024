/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Funcionario;
import model.Item;
import model.Pedido;

/**
 *
 * @author Root
 */
public class TestDAOs {
    public static void main(String[] args) throws Exception {
        PedidosDAO pDAO = new PedidosDAO();
        ItemDAO iDAO = new ItemDAO();
        FuncionarioDAO fDAO = new FuncionarioDAO();
////        
////        // Recupera o item com id 5
        Item i = iDAO.getCarregaPorId(5);
        System.out.println(i);
        Funcionario f = fDAO.getById(10);
//        // Cria e configura o pedido
        Pedido p = new Pedido();

        p.setId(p.getId());
        //f.setId(p.getId()); // ID do funcionário existente no banco de dados      
        
        p.setItem(i);
        p.setFuncionario(f);
        p.setValor(36.50);
        p.setNome("Pizza Portuguesa");
        p.setQtd(1); // Ajuste a quantidade conforme necessário
        // Tenta criar o pedido
        if (pDAO.create(p)) {
            System.out.println("Cadastrou pedidos_item");
            System.out.println(p.toString());
        } else {
            System.out.println("Erro ao cadastrar, pode ser algum id");
            System.out.println(p.toString());
        }

          System.out.println(pDAO.getAllPedidos());
    }

}
