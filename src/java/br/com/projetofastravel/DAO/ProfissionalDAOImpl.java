/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Cargo;
import br.com.projetofastravel.model.Empresa;
import br.com.projetofastravel.model.Profissional;
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
public class ProfissionalDAOImpl implements GenericDAO {

    private Connection conn;

    public ProfissionalDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Profissional profissional = (Profissional) object;
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO profissional(placa_veiculo_profissional, habilitacao_profissional, login_profissional, senha_profissional, id_cargo, id_empresa, id_pessoa) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, profissional.getPlacaVeiculo());
            stmt.setString(2, profissional.getHabilitacaoProfissional());
            stmt.setString(3, profissional.getLoginProfissional());
            stmt.setString(4, profissional.getSenhaProfissional());
            stmt.setInt(5, profissional.getCargo().getIdCargo());
            stmt.setInt(6, profissional.getEmpresa().getIdEmpresa());
            try{
            PessoaDAOImpl pessoa = new PessoaDAOImpl();
            stmt.setInt(7, pessoa.cadastrar(profissional));
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
    
    public Profissional verificarUsuario(String login, String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profissional profissional = null;
        Cargo cargo = null;
        Empresa empresa = null;
        String sql = "select pr.*, p.*, c.*, emp.* from profissional pr, pessoa p, cargo c, empresa emp where pr.login_profissional = ? and pr.senha_profissional = ? "
                     +"and p.id_pessoa = pr.id_pessoa and c.id_cargo = pr.id_cargo and pr.id_empresa = emp.id_empresa;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                profissional = new Profissional();
                profissional.setIdPessoa(rs.getInt("id_pessoa"));
                profissional.setIdProfissional(rs.getInt("id_profissional"));
                profissional.setNomePessoa(rs.getString("nome_pessoa"));
                profissional.setCpfCnpj(rs.getString("cpf_cnpj_pessoa"));
                profissional.setLoginProfissional(rs.getString("login_profissional"));
                profissional.setSenhaProfissional(rs.getString("senha_profissional"));
                profissional.setHabilitacaoProfissional(rs.getString("habilitacao_profissional"));
                profissional.setPlacaVeiculo(rs.getString("placa_veiculo_profissional"));
                profissional.setStatusPessoa(rs.getString("status_pessoa"));
                        
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNomeCargo(rs.getString("nome_cargo"));  
                
                empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                
                profissional.setEmpresa(empresa);
                profissional.setCargo(cargo);
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
        return profissional;
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, pr.*, c.* from pessoa p, profissional pr, cargo c where p.id_pessoa = pr.id_pessoa and c.id_cargo = pr.id_cargo";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Profissional profissional = new Profissional();
                
                 profissional.setIdPessoa(rs.getInt("id_pessoa"));
                 profissional.setNomePessoa(rs.getString("nome_pessoa"));
                 profissional.setCpfCnpj(rs.getString("cpf_cnpj_pessoa"));
                 profissional.setRgRazaosocial(rs.getString("rg_razaosocial_pessoa"));
                 profissional.setTelefonePessoa(rs.getString("telefone_pessoa"));
                 profissional.setRuaPessoa(rs.getString("rua_pessoa"));
                 profissional.setNumeroPessoa(rs.getInt("numero_pessoa"));
                 profissional.setBairroPessoa(rs.getString("bairro_pessoa"));
                 profissional.setCidadePessoa(rs.getString("cidade_pessoa"));
                 profissional.setStatusPessoa(rs.getString("status_pessoa"));
                 
                
                profissional.setIdProfissional(rs.getInt("id_profissional"));                 
                profissional.setLoginProfissional(rs.getString("login_profissional"));
                profissional.setSenhaProfissional(rs.getString("senha_profissional"));
                profissional.setPlacaVeiculo(rs.getString("placa_veiculo_profissional"));
                profissional.setHabilitacaoProfissional(rs.getString("habilitacao_profissional"));
                
                Cargo cargo = new Cargo();
                cargo.setNomeCargo(rs.getString("nome_cargo"));
                cargo.setIdCargo(rs.getInt("id_cargo"));
                profissional.setCargo(cargo);
                                
                resultado.add(profissional);
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
        String sql = "delete from profissional where id_pessoa=?; delete from pessoa where id_pessoa=?;";
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
        Profissional profissional = null;
        String sql = "select p.*, pr.* from pessoa p, profissional pr where p.id_pessoa = pr.id_pessoa and p.id_pessoa=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                profissional = new Profissional();
                profissional.setIdPessoa(rs.getInt("id_pessoa"));
                profissional.setNomePessoa(rs.getString("nome_pessoa"));
                profissional.setCpfCnpj(rs.getString("cpf_cnpj_pessoa"));
                profissional.setRgRazaosocial(rs.getString("rg_razaosocial_pessoa"));
                profissional.setTelefonePessoa(rs.getString("telefone_pessoa"));
                profissional.setRuaPessoa(rs.getString("rua_pessoa"));
                profissional.setNumeroPessoa(rs.getInt("numero_pessoa"));
                profissional.setBairroPessoa(rs.getString("bairro_pessoa"));
                profissional.setCidadePessoa(rs.getString("cidade_pessoa"));
                profissional.setStatusPessoa(rs.getString("status_pessoa"));
                
                profissional.setIdProfissional(rs.getInt("id_profissional"));
                profissional.setLoginProfissional(rs.getString("login_profissional"));
                profissional.setSenhaProfissional(rs.getString("senha_profissional"));
                profissional.setPlacaVeiculo(rs.getString("placa_veiculo_profissional"));
                profissional.setHabilitacaoProfissional(rs.getString("habilitacao_profissional"));
                
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
        return profissional;
    }

    @Override
    public Boolean alterar(Object object) {
       Profissional profissional = (Profissional) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE profissional SET placa_veiculo_profissional=?, habilitacao_profissional=?, login_profissional=?, senha_profissional=? WHERE id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, profissional.getPlacaVeiculo());
            stmt.setString(2, profissional.getHabilitacaoProfissional());
            stmt.setString(3, profissional.getLoginProfissional());
            stmt.setString(4, profissional.getSenhaProfissional());
            stmt.setInt(5, profissional.getIdPessoa());
            
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                if(daoPessoa.alterar(profissional)){
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
    
    public Boolean atualizarPosicao(Object object){
       Profissional profissional = (Profissional) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE profissional SET posicao_atual=? WHERE id_profissional=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, profissional.getPosicaoAtual());
            stmt.setInt(2, profissional.getIdProfissional());
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

    public String buscarPosicaoAtual(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        String posicaoAtual = null;
        String sql = "SELECT posicao_atual FROM profissional where id_profissional= ?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                posicaoAtual = rs.getString("posicao_atual");
                
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
        return posicaoAtual;
    }
    
    public Object carregarLoginSenha(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profissional profissional = null;
        String sql = "select id_profissional, login_profissional, senha_profissional from profissional where id_profissional = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                profissional = new Profissional();
                
                profissional.setIdProfissional(rs.getInt("id_profissional"));
                profissional.setLoginProfissional(rs.getString("login_profissional"));
                profissional.setSenhaProfissional(rs.getString("senha_profissional"));
                
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
        return profissional;
    }
    
    public Boolean alterarLoginSenha(Object object) {
       Profissional profissional = (Profissional) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE profissional SET login_profissional=?, senha_profissional=? WHERE id_profissional=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, profissional.getLoginProfissional());
            stmt.setString(2, profissional.getSenhaProfissional());
            stmt.setInt(3, profissional.getIdProfissional());
            stmt.executeUpdate();
        
            return true;
        
        } catch (SQLException ex) {
            System.out.println("Problemas ao Alterar! Erro:" + ex.getMessage());
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
