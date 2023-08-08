/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Administrador;
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
public class AdministradorDAOImpl implements GenericDAO {
    
    private Connection conn;
    
    public AdministradorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Administrador administrador = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrador(login_administrador, senha_administrador, email_administrador, nome_administrador, cpf_administrador, telefone_administrador)  VALUES (?, ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, administrador.getLoginAdministrador());
            stmt.setString(2, administrador.getSenhaAdministrador());
            stmt.setString(3, administrador.getEmailAdministrador());
            stmt.setString(4, administrador.getNomeAdministrador());
            stmt.setString(5, administrador.getCpfAdministrador());
            stmt.setString(6, administrador.getTelefoneAdministrador());
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
    
    public Administrador verificarUsuario(String login, String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador administrador = null;
        String sql = "select a.* from administrador a where a.login_administrador = ? and a.senha_administrador=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                administrador = new Administrador();
                administrador.setIdAministrador(rs.getInt("id_administrador"));
                administrador.setLoginAdministrador(rs.getString("login_administrador"));
                administrador.setSenhaAdministrador(rs.getString("senha_administrador"));
                administrador.setNomeAdministrador(rs.getString("nome_administrador"));
                administrador.setTelefoneAdministrador(rs.getString("telefone_administrador"));
                administrador.setEmailAdministrador(rs.getString("email_administrador"));
                administrador.setCpfAdministrador(rs.getString("cpf_administrador"));
                
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
        return administrador;
    }

    @Override
    public List<Object> listar() {
      List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select a.* from administrador a;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setIdAministrador(rs.getInt("id_administrador"));
                administrador.setNomeAdministrador(rs.getString("nome_administrador"));
                administrador.setEmailAdministrador(rs.getString("email_administrador"));
                administrador.setLoginAdministrador(rs.getString("login_administrador"));
                administrador.setSenhaAdministrador(rs.getString("senha_administrador"));
                administrador.setTelefoneAdministrador(rs.getString("telefone_administrador"));
                administrador.setCpfAdministrador(rs.getString("cpf_administrador"));
                resultado.add(administrador);
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
    public void excluir(int idObjetc) {
            PreparedStatement stmt = null;
        String sql = "Delete from administrador where id_administrador=?;";
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
        String sql = "select a.* from administrador a where a.id_administrador=?;";
        Administrador administrador = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                administrador = new Administrador();
                administrador.setIdAministrador(rs.getInt("id_administrador"));
                administrador.setLoginAdministrador(rs.getString("login_administrador"));
                administrador.setSenhaAdministrador(rs.getString("senha_administrador"));
                administrador.setEmailAdministrador(rs.getString("email_administrador"));
                administrador.setNomeAdministrador(rs.getString("nome_administrador"));
                administrador.setCpfAdministrador(rs.getString("cpf_administrador"));
                administrador.setTelefoneAdministrador(rs.getString("telefone_administrador"));
                
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
        return administrador;
    }

    @Override
    public Boolean alterar(Object object) {
        Administrador administrador = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE administrador SET login_administrador=?, senha_administrador=?, email_administrador=?, nome_administrador=?, cpf_administrador=?, telefone_administrador=? WHERE id_administrador=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, administrador.getLoginAdministrador());
            stmt.setString(2, administrador.getSenhaAdministrador());
            stmt.setString(3, administrador.getEmailAdministrador());
            stmt.setString(4, administrador.getNomeAdministrador());
            stmt.setString(5, administrador.getCpfAdministrador());
            stmt.setString(6, administrador.getTelefoneAdministrador());
            stmt.setInt(7, administrador.getIdAministrador());
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
    

