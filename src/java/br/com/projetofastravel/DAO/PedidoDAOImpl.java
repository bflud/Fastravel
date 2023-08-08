/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Pedido;
import br.com.projetofastravel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class PedidoDAOImpl implements GenericDAO{

     private Connection conn;
    
    public PedidoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Pedido pedido = (Pedido) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO pedido(data_pedido, status_pedido, horario_chegada_pedido, referencia_pedido, rua_pedido, bairro_pedido, numero_pedido, descricao_pedido, contato_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setString(2, pedido.getStatusPedido());
            stmt.setString(3, pedido.getHorarioChegadaPedido());
            stmt.setString(4, pedido.getReferenciaPedido());
            stmt.setString(5, pedido.getRuaPedido());
            stmt.setString(6, pedido.getBairroPedido());
            stmt.setInt(7, pedido.getNumeroPedido());
            stmt.setString(8, pedido.getDescricaoPedido());
            stmt.setString(9, pedido.getContatoCliente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao! ERRO:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
      List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.* from pedido p;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                pedido.setHorarioChegadaPedido(rs.getString("horario_chegada_pedido"));
                pedido.setReferenciaPedido(rs.getString("referencia_pedido"));
                pedido.setNumeroPedido(rs.getInt("numero_pedido"));
                pedido.setRuaPedido(rs.getString("rua_pedido"));
                pedido.setBairroPedido(rs.getString("bairro_pedido"));
                pedido.setContatoCliente(rs.getString("contato_cliente"));
                pedido.setDescricaoPedido(rs.getString("descricao_pedido"));
                resultado.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar modalidade Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    
    }

    @Override
    public void excluir(int idObject) {
            PreparedStatement stmt = null;
        String sql = "delete from pedido_entrega where id_pedido=?; Delete from pedido where id_pedido=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conexao " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.* from pedido p where p.id_pedido=?;";
        Pedido pedido = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                pedido.setReferenciaPedido(rs.getString("referencia_pedido"));
                pedido.setRuaPedido(rs.getString("rua_pedido"));
                pedido.setBairroPedido(rs.getString("bairro_pedido"));
                pedido.setContatoCliente(rs.getString("contato_cliente"));
                pedido.setDescricaoPedido(rs.getString("descricao_pedido"));
                pedido.setNumeroPedido(rs.getInt("numero_pedido"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conexao " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pedido;
    }

    @Override
    public Boolean alterar(Object object) {
        Pedido pedido = (Pedido) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE pedido SET data_pedido=?, status_pedido=?, referencia_pedido=?, rua_pedido=?, bairro_pedido=?, numero_pedido=?, descricao_pedido=?, contato_cliente=? WHERE id_pedido=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setString(2, pedido.getStatusPedido());
            stmt.setString(3, pedido.getReferenciaPedido());
            stmt.setString(4, pedido.getRuaPedido());
            stmt.setString(5, pedido.getBairroPedido());
            stmt.setInt(6, pedido.getNumeroPedido());
            stmt.setString(7, pedido.getDescricaoPedido());
            stmt.setString(8, pedido.getContatoCliente());
            stmt.setInt(8, pedido.getIdPedido());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao! ERRO:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
}
