/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.PedidoEntrega;
import br.com.projetofastravel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class PedidoEntregaDAOImpl implements GenericDAO{

      private Connection conn;
    
    public PedidoEntregaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro:" + ex.getMessage());
        }
    }    

    
    @Override
    public Boolean cadastrar(Object object) {

        PedidoEntrega pedidoentrega = (PedidoEntrega) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO pedido_entrega(id_pedido, id_entrega, status_pedido_entrega) VALUES (?, ?, ?);";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pedidoentrega.getPedido().getIdPedido());            
            stmt.setInt(2, pedidoentrega.getEntrega().getIdEntrega());
            stmt.setString(3, pedidoentrega.getStatusPedidoEntrega());

            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas na DAO ao cadastrar Itens da Entrega! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idObjetc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
