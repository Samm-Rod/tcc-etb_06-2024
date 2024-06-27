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
import model.Item;
import model.Pedido;

/**
 *
 * @author Root
 */
public class ItemDAO extends DatabaseDAO{
    
    public ItemDAO()throws Exception{
        
    }
    
    
    public ArrayList<Item> getLista() throws Exception{
        ArrayList<Item> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM item";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Item i = new Item();
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            lista.add(i);
        }
        this.desconectar();
        return lista;
    }
    
    public Item getByIdItem(int id){
        String sql = "SELECT * FROM item WHERE id="+id;
        Item i = new Item();
        ArrayList<Item> lista = new ArrayList<>();
        try{
            this.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i.setId(rs.getInt(1));
                i.setNome(rs.getString(2));
                i.setValor(rs.getDouble(3));
                i.setDescricao(rs.getString(4));
                i.setArqImg(rs.getString(5));
                lista.add(i);
            }
            this.desconectar();
            
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return i;
    }
    
    
    // Para o funcionario
    public boolean gravar(Item i){
        try{
            String sql;
            this.conectar();
            
            if(i.getId() == 0){
                sql = "INSERT INTO item(nome, valor, descricao, arqImg) VALUES (?,?,?,?)";
            }else{
                sql = "UPDATE item SET nome=?, valor=?, descricao=?, arqImg=? WHERE id=?";
            }
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, i.getNome());
            st.setDouble(2, i.getValor());
            st.setString(3, i.getDescricao());
            st.setString(4, i.getArqImg());
            
            if(i.getId()>0){
                st.setInt(5, i.getId());
            }
            st.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public Item getLoadPorId(int id) throws Exception{
        Item i = new Item();
        String sql = "SELECT id, nome, valor FROM item WHERE id=?";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            
        }
        this.desconectar();
        return i;
    }
        
    
    public Item getCarregaPorId(int id) throws Exception{
        Item i = new Item();
        String sql = "SELECT * FROM item WHERE id=?";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            
        }
        this.desconectar();
        return i;
    }
    
    
    public boolean deletar(Item i){
        
        try{
            this.conectar();
            String sql = "DELETE FROM item WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i.getId());
            ps.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
        
    public Double somaTotal(int id) throws Exception{
        Item i = new Item();
        String sql = "SELECT nome, valor, qtd "
                + "FROM item "
                + "WHERE id=? ";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setQtd(rs.getInt("qtd"));
        }
        double total = i.getQtd() * i.getValor(); // Correção aqui
        this.desconectar();
        return total;
    }
    
//    public ArrayList<Item> getItemById(int id) throws Exception{
//        ArrayList
//        Item i = new Item();
//        String sql = "SELECT nome, valor, descricao, arqImg "
//           + "FROM item "
//           + "WHERE nome LIKE ?";
//        this.conectar();
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setInt(1,id);
//        
//        ResultSet rs = ps.executeQuery();
//        if(rs.next()){
//            i.setId(rs.getInt("id"));
//            i.setNome(rs.getString("nome"));
//            i.setValor(rs.getDouble("valor"));
//            i.setDescricao(rs.getString("descricao"));
//            i.setArqImg(rs.getString("arqImg"));
//            
//        }
//        this.desconectar();
//        return i;
//    }
        // busca vários
     public ArrayList<Item> getAllHam() throws Exception{
        ArrayList<Item> lista = new ArrayList<>();
        
        String sql = "SELECT id, nome, valor, descricao, arqImg "
           + "FROM item "
           + "WHERE nome LIKE 'Ham%'OR'ham%'";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Item i = new Item();
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            lista.add(i);
        }
        this.desconectar();
        return lista;
    }
    
    // busca 1
        public Item getHamById(int id) throws Exception{
        Item i = new Item();
        String sql = "SELECT id, nome, valor, descricao, arqImg "
           + "FROM item "
           + "WHERE nome LIKE 'Ham%'OR'ham%'";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            
        }
        this.desconectar();
        return i;
    }
        
         public ArrayList<Item> getAllPizza() throws Exception{
        ArrayList<Item> lista = new ArrayList<>();
        
        String sql = "SELECT id, nome, valor, descricao, arqImg "
           + "FROM item "
           + "WHERE nome LIKE 'Piz%'OR'piz%'";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Item i = new Item();
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            lista.add(i);
        }
        this.desconectar();
        return lista;
    }
    
    // busca 1
        public Item getPizzaById(int id) throws Exception{
        Item i = new Item();
        String sql = "SELECT id, nome, valor, descricao, arqImg "
           + "FROM item "
           + "WHERE nome LIKE 'Piz%'OR'piz%'";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            
        }
        this.desconectar();
        return i;
    } 
        
    
    public ArrayList<Item> getAllBebidas() throws Exception{
        ArrayList<Item> lista = new ArrayList<>();
        
        String sql = "SELECT id, nome, valor, descricao, arqImg "
           + "FROM item "
           + "WHERE nome LIKE 'Ref%'OR'Suc%'";

        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Item i = new Item();
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setDescricao(rs.getString("descricao"));
            i.setArqImg(rs.getString("arqImg"));
            lista.add(i);
        }
        this.desconectar();
        return lista;
    }  
    
}
