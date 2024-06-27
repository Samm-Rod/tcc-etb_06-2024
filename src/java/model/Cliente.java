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
public class Cliente {
    private int id;
    private String cpf;
    private Mesa mesa;

    public Cliente() {
    }

    public Cliente(int id, String cpf, Mesa mesa) {
        this.id = id;
        this.cpf = cpf;
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "--------\nCliente{" + 
                "\nId: " + id + 
                "\nCPF: " + cpf + 
                "\nMesa: " + mesa;
    }
    
    
    
}
