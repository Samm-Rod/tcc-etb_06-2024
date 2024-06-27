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
public class Mesa {

    private int id;
    private int numMesa;
    
    public Mesa(){
        
    }

    public Mesa(int id, int numMesa) {
        this.id = id;
        this.numMesa = numMesa;
        
    }
    
    

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public String toString() {
        return "--------\nMesa" + 
                "\n Id: " + id + 
                "\n Numero da Mesa: " + numMesa;
    }
    
    
    
    
}

