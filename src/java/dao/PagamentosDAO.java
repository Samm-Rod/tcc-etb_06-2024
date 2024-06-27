/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Item;
import model.Pagamentos;
import model.Pedido;

/**
 *
 * @author Root
 */
public class PagamentosDAO extends DatabaseDAO {

    public PagamentosDAO() throws Exception{

    }
    
    public ArrayList<Pagamentos> getAllPagamentos() throws Exception {
        ArrayList<Pagamentos> lista = new ArrayList<>();
        try{
            
            String sql = "SELECT tipoPag, valor, cliente_id FROM pagamentos WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pagamentos p = new Pagamentos();
                Cliente c = new Cliente();
                p.setId(rs.getInt("id")) ;
                p.setTipoPag(rs.getString("tipoPag"));
                p.setValor(rs.getDouble("valor"));
                c.setId(c.getId());
                p.setCliente(c);
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;


    }
    
    
    public boolean gravar(Pagamentos p){

        try{
            String sql="";
            this.conectar();
            
            if(p.getId() == 0){
                sql = "INSERT INTO pagamentos(tipoPag, valor, cliente_id) VALUES (?,?,?)";
            }else{
                sql = "UPDATE pagamentos SET tipoPag=?,valor=?,cliente_id=? WHERE id=?";
            }

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getTipoPag());
            st.setDouble(2, p.getValor());
            st.setInt(3, p.getCliente().getId());
            if(p.getId()>0){
                st.setInt(4, p.getId());
            }
            st.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    

    
    
    
}
