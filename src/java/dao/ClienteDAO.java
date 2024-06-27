/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Funcionario;
import model.Mesa;

/**
 *
 * @author Root
 */
public class ClienteDAO extends DatabaseDAO{
    
    public ClienteDAO() throws Exception{
        
    }
    
    // Listar cliente 
    public ArrayList<Cliente> getLista() throws Exception{
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM cliente";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Cliente c = new Cliente();
            Mesa m = new Mesa();
            c.setId(rs.getInt("id"));
            c.setCpf(rs.getString("cpf"));
            m.getId();
            c.setMesa(m);
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }
    
    
    public boolean gravar(Cliente c){
        try{
            String sql = "";
            this.conectar();
            
            if(c.getId() == 0){
                sql = "INSERT INTO cliente(cpf, mesas_id) VALUES (?,?)";
            }
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getCpf());
            st.setInt(2, c.getMesa().getId());

            if(c.getId()>0){
                st.setInt(3, c.getId());
            }
            st.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }

   
    public Cliente getById(int id) throws Exception{
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id=?";
        this.conectar();
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            c.setId(rs.getInt("id"));
            c.setCpf(rs.getString("cpf"));
            Mesa m = new Mesa();
            m.getId();
            c.setMesa(m);
        }
        this.desconectar();
        return c;
    }

    public boolean deletar(Cliente c){
        
        try{
            this.conectar();
            String sql = "DELETE FROM cliente WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }
    
}
