/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funcionario;

import model.Mesa;

/**
 *
 * @author Root
 */
public class MesaDAO extends DatabaseDAO{
    
    public MesaDAO() throws Exception {
        
    }
    
    public ArrayList<Mesa> getLista() throws Exception{
        ArrayList<Mesa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM mesas";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Mesa m = new Mesa();
            m.setId(rs.getInt("id"));
            m.setNumMesa(rs.getInt("numMesa"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Mesa m){
        try{
            String sql = "";
            this.conectar();
            
            if (m.getId() == 0) {
                // Inserção (INSERT) quando id é zero
                sql = "INSERT INTO mesas (numMesa) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, m.getNumMesa());
                ps.executeUpdate();
            } else {
                // Atualização (UPDATE) quando id é maior que zero
                sql = "UPDATE mesas SET numMesa=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, m.getNumMesa());
                ps.setInt(2, m.getId());
                ps.executeUpdate();
            }  
            
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println("Erro ao gravar no banco de dados !"+e.getMessage());
            return false;
        }
        
    }
    
    public Mesa getCarregaPorId(int id) throws Exception{
        Mesa f = new Mesa();
        String sql = "SELECT * FROM mesas WHERE id=?";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            f.setId(rs.getInt("id"));
            f.setNumMesa(rs.getInt("numMesa"));
        }
        this.desconectar();
        return f;
    }
    
        public boolean deletar(Mesa m){
        
        try{
            this.conectar();
            String sql = "DELETE FROM mesas WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, m.getId());
            ps.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }
    
    
    
}
