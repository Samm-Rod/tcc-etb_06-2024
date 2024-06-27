/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Root
 */
public class Item {
    private int id;
    private String nome;
    private double valor;
    private String descricao;
    private String arqImg;
    private Pedido pedido;
    private int qtd;

    public Item(){
        
    }

    public Item(int id, String nome, double valor, String descricao, String arqImg, Pedido pedido, int qtd) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.arqImg = arqImg;
        this.pedido = pedido;
        this.qtd = qtd;
    }


    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public String getArqImg() {
        return arqImg;
    }

    public void setArqImg(String arqImg) {
        this.arqImg = arqImg;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    

    @Override
    public String toString() {
        return "-------\nItem" + 
                "\nId: " + id + 
                "\nNome: " + nome + 
                "\nValor: " + valor + 
                "\nDescricao: " + descricao + 
                "\nArqImg: " + arqImg + 
                "\nPedido: " + pedido +
                "\nQtd: "+ qtd;
    }

    
    
    
    
    
    
    
}
