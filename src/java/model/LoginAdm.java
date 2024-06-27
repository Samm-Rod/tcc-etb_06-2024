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
public class LoginAdm {
    
    private int id;
    private String matricula;
    private String senha;

    public LoginAdm(int id, String matricula, String senha) {
        this.id = id;
        this.matricula = matricula;
        this.senha = senha;
    }
    
    public LoginAdm(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
