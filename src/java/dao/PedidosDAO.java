/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Item;
import model.Pedido;

/**
 *
 * @author Root
 */
public class PedidosDAO extends DatabaseDAO {

    public PedidosDAO() throws Exception {

    }
    
    public ArrayList<Pedido> getPedidos() throws Exception {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = "SELECT pedido_id, qtd, valor, nome FROM pedidos_item"; // Ajuste conforme o nome das colunas na sua tabela
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pedido p = new Pedido();
            p.setId(rs.getInt("pedido_id")); // Use a coluna correta aqui
            p.setQtd(rs.getInt("qtd"));
            p.setValor(rs.getDouble("valor"));
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    
    public ArrayList<Pedido> getAllPedidos() throws Exception {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = "SELECT pi.pedidos_id, pi.item_id, pi.qtd, pi.valor, pi.nome, pi.total, i.arqImg " +
                     "FROM pedidos_item pi " +
                     "JOIN item i "+
                     "ON pi.item_id = i.id";

        this.conectar();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                Item i = new Item();

                p.setId(rs.getInt("pedidos_id"));
                i.setId(rs.getInt("item_id"));
                p.setItem(i);
                p.setQtd(rs.getInt("qtd"));
                p.setValor(rs.getDouble("valor"));
                p.setNome(rs.getString("nome"));
                p.setTotal(rs.getDouble("total"));
                i.setArqImg(rs.getString("arqImg"));
                p.setItem(i);

                lista.add(p);
            }

            rs.close();
            ps.close();
        } finally {
            this.desconectar();
        }

        return lista;
    }
    
// Método create no DAO
    public boolean create(Pedido p) {
        try {
            this.conectar();
            conn.setAutoCommit(false); // Inicia a transação

            // Verifica se o objeto Funcionario existe e tem um ID válido
            if (p.getFuncionario() == null || p.getFuncionario().getId() == 0) {
                throw new IllegalArgumentException("Funcionário inválido ou não definido.");
            }

            // Verifica se o objeto Item existe e tem um ID válido
            if (p.getItem() == null || p.getItem().getId() == 0) {
                throw new IllegalArgumentException("Item inválido ou não definido.");
            }

            String sqlPedido = "INSERT INTO pedidos(funcionario_id) VALUES (?)";
            
            String sqlPedidoItem = "INSERT INTO pedidos_item(pedidos_id, item_id, valor, nome, qtd) VALUES (?, ?, ?, ?, ?)";
            
            String sqlUpdatePedidoItem = "UPDATE pedidos_item SET qtd=?, valor=?, nome=? WHERE pedidos_id=? AND item_id=?";

            // Se o pedido é novo (id == 0), inserimos na tabela 'pedidos' primeiro
            if (p.getId() == 0) {
                PreparedStatement psPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
                psPedido.setInt(1, p.getFuncionario().getId());
                psPedido.executeUpdate();

                ResultSet rs = psPedido.getGeneratedKeys();
                if (rs.next()) {
                    p.setId(rs.getInt(1)); // Define o ID gerado para o pedido
                }
                rs.close();
                psPedido.close();
            }

            // Agora, inserimos ou atualizamos os itens do pedido
            PreparedStatement psItem;
            if (p.getQtd() > 0) {
                // Inserindo novos itens do pedido
                psItem = conn.prepareStatement(sqlPedidoItem);
                psItem.setInt(1, p.getId()); // pedidos_id
                psItem.setInt(2, p.getItem().getId()); // item_id
                psItem.setDouble(3, p.getValor()); // valor
                psItem.setString(4, p.getNome()); // nome
                psItem.setInt(5, p.getQtd()); // qtd
                System.out.println("Creates: "+p.toString());
            } else {
                // Atualizando quantidade dos itens existentes
                psItem = conn.prepareStatement(sqlUpdatePedidoItem);
                psItem.setInt(1, p.getQtd()); // qtd
                psItem.setDouble(2, p.getValor()); // valor
                psItem.setString(3, p.getNome()); // nome
                psItem.setInt(4, p.getId()); // pedidos_id
                psItem.setInt(5, p.getItem().getId()); // item_id
                System.out.println("Updates: "+p.toString());
            }
            psItem.executeUpdate();
            psItem.close();

            conn.commit(); // Commit da transação
            this.desconectar();
            return true;
        } catch (Exception e) {
            try {
                conn.rollback(); // Rollback da transação em caso de erro
            } catch (SQLException e1) {
                System.out.println("Erro ao realizar rollback! " + e1.getMessage());
            }
            System.out.println("Erro ao gravar no banco de dados! " + e.getMessage());
            return false;
        }
    }
    
    public int obterNovoIdPedido() throws SQLException, Exception {
        int novoIdPedido = 0;
        try {
            this.conectar();
            String sql = "SELECT MAX(id) AS max_id FROM pedidos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                novoIdPedido = rs.getInt("max_id") + 1;
            } else {
                novoIdPedido = 1; // Caso não haja registros, começamos pelo ID 1
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao obter novo ID de pedido: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return novoIdPedido;
    }
        
    // Método getPorId no DAO
    public int getPorId(int id) throws Exception {
        Item i = new Item();
        String sql = "SELECT id, nome, valor FROM item WHERE id=?";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
        }
        this.desconectar();
        return i.getId();
    }

    public boolean gravar(Pedido p) {
        try {
            String sql = "";
            this.conectar();

            if (p.getId() == 0) {
                // Inserção (INSERT) quando id é zero
                sql = "UPDATE pedidos SET qtd=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.setInt(2, p.getQtd());
                
                ps.executeUpdate();
            }

            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao gravar no banco de dados !" + e.getMessage());
            return false;
        }

    }
    
    
    public ArrayList<Pedido> getSelect() throws Exception {
        ArrayList<Pedido> pLista = new ArrayList<>();
        Item i = new Item();

        String sql = "SELECT id, qtd FROM pedidos";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Pedido p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setQtd(rs.getInt("qtd"));

            pLista.add(p);
        }
        this.desconectar();
        return pLista;
    }
    
    public ArrayList<Pedido> getLista() throws Exception {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.valor, p.descricao, i.arqImg " +
                     "FROM pedidos p " +
                     "JOIN pedidos_item i ON p.id = i.pedidos_id";

        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getDouble("valor"));
            p.setDescricao(rs.getString("descricao"));

            Item i = new Item();
            i.setArqImg(rs.getString("arqImg"));
            p.setItem(i);

            lista.add(p);
        }

        rs.close();
        ps.close();
        this.desconectar();

        return lista;
    }

    

    public ArrayList<Pedido> getListas() throws Exception {
        ArrayList<Pedido> pLista = new ArrayList<>();
        Item i = new Item();

        String sql = "SELECT p.id, "
                + "i.nome, i.valor "
                + "FROM Pedidos p "
                + "INNER JOIN Item i "
                + "ON i.id = p.id ";
        this.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Pedido p = new Pedido();
            //p.setQtd(rs.getInt("qtd"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            //i.setArqImg(rs.getString("arqImg"));
            p.setItem(i);
            pLista.add(p);
        }
        this.desconectar();
        return pLista;
    }
    
    
//    public Pedido getByIds(){
//       Item i = new Item();
//       String sql = "SELECT FROM ";
//    }

    public Pedido getById(int id) throws Exception {
        Pedido p = new Pedido();
        ArrayList<Item> itens = new ArrayList<>();
        Item i = new Item();
        String sql = "SELECT p.momento, p.statusPedido, p.qtd, " +
                "i.nome, i.valor, i.arqImg " +
                "FROM Pedidos p " +
                "INNER JOIN Item i " +
                "ON p.id = i.pedidos_id " +
                "WHERE p.id = ?";
        this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setQtd(rs.getInt("qtd"));

            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setValor(rs.getDouble("valor"));
            i.setArqImg(rs.getString("arqImg"));
            itens.add(i);
        }
        this.desconectar();
        return p;
    }

    public boolean deletar(Pedido p) {

        try {
            this.conectar();
            String sql = "DELETE FROM pedidos_item WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

}
