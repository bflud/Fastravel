/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Cargo;
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
public class CargoDAOImpl implements GenericDAO{

    private Connection conn;
    
    public CargoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }
    @Override
    public Boolean cadastrar(Object object) {
         Cargo cargo = (Cargo) object;
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO cargo (nome_cargo) VALUES (?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cargo.getNomeCargo());
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
        String sql = "SELECT id_cargo, nome_cargo FROM cargo;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                
                 cargo.setIdCargo(rs.getInt("id_cargo"));
                 cargo.setNomeCargo(rs.getString("nome_cargo"));
                 
                resultado.add(cargo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Erro: " + ex.getMessage());
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
    public void excluir(int idObjetc) {
        PreparedStatement stmt = null;
        String sql = "delete from cargo where id_cargo=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObjetc);
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
        Cargo cargo = null;
        String sql = "select c.* from cargo c where id_cargo=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNomeCargo(rs.getString("nome_cargo"));
                
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
        return cargo;
    }

    @Override
    public Boolean alterar(Object object) {
       Cargo cargo = (Cargo) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cargo SET nome_cargo=? WHERE id_cargo=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cargo.getNomeCargo());
            stmt.setInt(2, cargo.getIdCargo());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar cargo! Erro:" + ex.getMessage());
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
