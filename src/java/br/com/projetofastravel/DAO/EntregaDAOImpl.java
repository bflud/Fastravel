/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Entrega;
import br.com.projetofastravel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor
 */
public class EntregaDAOImpl {

    
    private Connection conn;
    
    public EntregaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }
    
  
    
        public Integer cadastrar(Object object) {
        Entrega entrega = (Entrega) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idEntrega = 0;
        String sql = "INSERT INTO entrega(horario_saida_entrega, id_profissional, data_entrega) VALUES (?, ?, ?) returning id_entrega;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, entrega.getHorarioSaidaEntrega());
            stmt.setInt(2, entrega.getProfissional().getIdProfissional());
            stmt.setDate(3,new java.sql.Date(entrega.getDataEntrega().getTime()));
            rs = stmt.executeQuery();
            
            while (rs.next()){
                idEntrega = rs.getInt("id_entrega");
            }

            
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao! ERRO:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idEntrega;
    }

    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(int idObjetc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
