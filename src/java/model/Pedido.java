/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Root
 */
public class Pedido {
    
    private int id;
    private Funcionario funcionario;
    private Item item;
    private int qtd;
    private double valor;
    private String nome;
    private String descricao;
    private double total;

    public Pedido(int id, Funcionario funcionario, Item item, int qtd, double valor, String nome, String descricao, double total) {
        this.id = id;
        this.funcionario = funcionario;
        this.item = item;
        this.qtd = qtd;
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
        this.total = total;
    }

    public Pedido(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        total = this.getValor() * this.getQtd();
        this.total = total;
    }

    @Override
    public String toString() {
        return "----------\nPedido" + 
                "\nId: " + id + 
                "\nFuncionario: " + funcionario + 
                "\nItem: " + item + 
                "\nQTD: " + qtd + 
                "\nValor: R$ " + valor + 
                "\nNome: " + nome + 
                "\nTotal: " + total;
    }

    
    
    
    
    
}
