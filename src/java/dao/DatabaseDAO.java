/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Root
 */
public class DatabaseDAO {
    
    public final String URL = "jdbc:mysql://localhost:3306/menu_db";
    public final String USER= "root";
    public final String SENHA= "";
    public Connection conn;
    
    public DatabaseDAO() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    
    public void conectar() throws Exception{
        conn = DriverManager.getConnection(URL,USER,SENHA);
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
    
}
