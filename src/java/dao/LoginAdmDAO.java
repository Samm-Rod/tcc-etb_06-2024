/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Funcionario;
import model.LoginAdm;

/**
 *
 * @author Root
 */
public class LoginAdmDAO extends DatabaseDAO{
    
    public LoginAdmDAO () throws Exception{
        
    }
    

    
    public boolean gravar(Funcionario f){
        try{
            
            String sql = "INSERT INTO loginadm (matricula, senha) VALUES (?,?)";
            this.conectar();
            
            this.desconectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
        }catch(Exception e){
            System.out.println("Erro ao logar "+e.getMessage());
        }
        return false;
    }

    public LoginAdm getById(int id) throws Exception{
        int count  = 0;
        count += 1;
        LoginAdm l = new LoginAdm();
        String sql = "SELECT * FROM loginAdm WHERE id=? ";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            l.setId(rs.getInt("id"));
            l.setMatricula(rs.getString("matricula"));
            l.setSenha(rs.getString("senha"));
        }
        this.desconectar();
        return l;
    }
    
    
}
