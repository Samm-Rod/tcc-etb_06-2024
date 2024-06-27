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
public class Funcionario {
    
    private int id;
    private String nome;
    private Date dataNasc;
    private String cpf;
    private String tel;
    private String matricula;
    private String senha;
    private LoginAdm loginAdm;

    public Funcionario(int id, String nome, Date dataNasc, String cpf, String tel, String matricula, String senha, LoginAdm loginAdm) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.tel = tel;
        this.matricula = matricula;
        this.senha = senha;
        this.loginAdm = loginAdm;
    }


    
    
    public Funcionario(){
        
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public LoginAdm getLoginAdm() {
        return loginAdm;
    }

    public void setLoginAdm(LoginAdm loginAdm) {
        this.loginAdm = loginAdm;
    }
    
    

    @Override
    public String toString() {
        return "-------\nFuncionario{" + 
                "\nId: " + id + 
                "\nNome: " + nome + 
                "\nDataNasc: " + dataNasc + 
                "\nCPF: " + cpf + 
                "\nTel:" + tel + 
                "\nMatricula: " + matricula + 
                "\nSenha: " + senha;
    }

    
    
    
    
    
}
