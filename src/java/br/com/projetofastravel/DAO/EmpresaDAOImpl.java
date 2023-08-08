/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Empresa;
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
public class EmpresaDAOImpl implements GenericDAO{

    private Connection conn;
    
    public EmpresaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }

    
    @Override
    public Boolean cadastrar(Object object) {
         Empresa empresa = (Empresa) object;
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO empresa(setor_comercial_empresa, id_pessoa) VALUES (?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getSetorComercialEmpresa());
            try{
            PessoaDAOImpl pessoa = new PessoaDAOImpl();
            stmt.setInt(2, pessoa.cadastrar(empresa));
            }catch(Exception ex){
                System.out.println("Problemas ao cadastrar! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
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
        String sql = "select p.*, e.* from pessoa p, empresa e where p.id_pessoa = e.id_pessoa";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                
                 empresa.setIdPessoa(rs.getInt("id_pessoa"));
                 empresa.setNomePessoa(rs.getString("nome_pessoa"));
                 empresa.setCpfCnpj(rs.getString("cpf_cnpj_pessoa"));
                 empresa.setRgRazaosocial(rs.getString("rg_razaosocial_pessoa"));
                 empresa.setTelefonePessoa(rs.getString("telefone_pessoa"));
                 empresa.setRuaPessoa(rs.getString("rua_pessoa"));
                 empresa.setNumeroPessoa(rs.getInt("numero_pessoa"));
                 empresa.setBairroPessoa(rs.getString("bairro_pessoa"));
                 empresa.setCidadePessoa(rs.getString("cidade_pessoa"));
                 empresa.setStatusPessoa(rs.getString("status_pessoa"));
                
                 empresa.setIdEmpresa(rs.getInt("id_empresa"));
                 empresa.setSetorComercialEmpresa(rs.getString("setor_comercial_empresa"));
                resultado.add(empresa);
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
        String sql = "delete from empresa where id_pessoa=?; delete from pessoa where id_pessoa=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObjetc);
            stmt.setInt(2, idObjetc);
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
        Empresa empresa = null;
        String sql = "select p.*, e.* from pessoa p, empresa e where p.id_pessoa = e.id_pessoa and p.id_pessoa=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setIdPessoa(rs.getInt("id_pessoa"));
                empresa.setNomePessoa(rs.getString("nome_pessoa"));
                empresa.setCpfCnpj(rs.getString("cpf_cnpj_pessoa"));
                empresa.setRgRazaosocial(rs.getString("rg_razaosocial_pessoa"));
                empresa.setTelefonePessoa(rs.getString("telefone_pessoa"));
                empresa.setRuaPessoa(rs.getString("rua_pessoa"));
                empresa.setNumeroPessoa(rs.getInt("numero_pessoa"));
                empresa.setBairroPessoa(rs.getString("bairro_pessoa"));
                empresa.setCidadePessoa(rs.getString("cidade_pessoa"));
                empresa.setStatusPessoa(rs.getString("status_pessoa"));
                
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setSetorComercialEmpresa(rs.getString("setor_comercial_empresa"));
                
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
        return empresa;
    }

    @Override
    public Boolean alterar(Object object) {
       Empresa empresa = (Empresa) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE empresa SET setor_comercial_empresa=? WHERE id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getSetorComercialEmpresa());
            stmt.setInt(2, empresa.getIdPessoa());
            
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                if(daoPessoa.alterar(empresa)){
                    stmt.executeUpdate();
                    return true;
                }else{
                    return false;
                }
            } catch (Exception ex) {
                System.out.println("Problmas ao alterar funcionario");
                ex.printStackTrace();
                return false;
            }
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
