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
public class Carrinho {
    
    private int id;
    private int idItem;
    private String nome;
    private double valor;
    private String descricao;
    private String arqImg;
    private int qtd;
    private double total;

    public Carrinho() {
    }

    public Carrinho(int id, int idItem, String nome, double valor, String descricao, String arqImg, int qtd, double total) {
        this.id = id;
        this.idItem = idItem;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.arqImg = arqImg;
        this.qtd = qtd;
        this.total = total;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
