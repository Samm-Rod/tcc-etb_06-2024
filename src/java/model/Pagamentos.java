/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Root
 */
public class Pagamentos {
    private int id;
    private String tipoPag;
    private double valor;
    private Date momento;
    private Cliente cliente;

    public Pagamentos(int id, String tipoPag, double valor, Date momento, Cliente cliente) {
        this.id = id;
        this.tipoPag = tipoPag;
        this.valor = valor;
        this.momento = momento;
        this.cliente = cliente;
    }



    public Pagamentos() {
    }

    public Pagamentos(int pagamentoId, String tipoPag, double valor, int clienteId, String cpf, int numMesa, String itemNome, double itemTotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPag() {
        return tipoPag;
    }

    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }



    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "------\nPagamentos" + 
                "\nId: " + id + 
                "\nTipoPag: " + tipoPag + 
                "\nValor: " + valor + 
                "\nMomento: " + momento + 
                "\nCliente: " + cliente;
    }
    
    
    
}
