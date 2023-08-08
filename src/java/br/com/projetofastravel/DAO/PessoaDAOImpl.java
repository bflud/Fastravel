/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import br.com.projetofastravel.model.Pessoa;
import br.com.projetofastravel.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class PessoaDAOImpl {
      
    private Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar! Erro:" + ex.getMessage());
        }
    }
    
    public Integer cadastrar(Pessoa pessoa){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO pessoa(nome_pessoa, cpf_cnpj_pessoa, rg_razaosocial_pessoa, telefone_pessoa, rua_pessoa, numero_pessoa, bairro_pessoa, cidade_pessoa, status_pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) returning id_pessoa;";
        int idPessoa = 0;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfCnpj());
            stmt.setString(3, pessoa.getRgRazaosocial());
            stmt.setString(4, pessoa.getTelefonePessoa());
            stmt.setString(5, pessoa.getRuaPessoa());
            stmt.setInt(6, pessoa.getNumeroPessoa());
            stmt.setString(7, pessoa.getBairroPessoa());
            stmt.setString(8, pessoa.getCidadePessoa());
            stmt.setString(9, pessoa.getStatusPessoa());
            
            rs = stmt.executeQuery();
            while (rs.next()){
                idPessoa = rs.getInt("id_pessoa");
        }
      }catch (SQLException ex){
            System.out.println("Problemas ao cadastrar pessoa! Erro: "+ ex.getMessage());
            ex.printStackTrace();
      }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch (Exception ex){
                System.out.println("Problemas ao fechar os parametros de conexao! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idPessoa;        
}
    
    public Boolean alterar(Pessoa pessoa){
        PreparedStatement stmt = null;
        String sql = "UPDATE pessoa SET nome_pessoa=?, cpf_cnpj_pessoa=?, rg_razaosocial_pessoa=?, telefone_pessoa=?, rua_pessoa=?, numero_pessoa=?, bairro_pessoa=?, cidade_pessoa=?, status_pessoa=? WHERE id_pessoa=?;";        
        
        try {
            stmt = conn.prepareStatement(sql);            
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfCnpj());
            stmt.setString(3, pessoa.getRgRazaosocial());
            stmt.setString(4, pessoa.getTelefonePessoa());
            stmt.setString(5, pessoa.getRuaPessoa());
            stmt.setInt(6, pessoa.getNumeroPessoa());
            stmt.setString(7, pessoa.getBairroPessoa());
            stmt.setString(8, pessoa.getCidadePessoa());
            stmt.setString(9, pessoa.getStatusPessoa());
            stmt.setInt(10, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
      }catch (SQLException ex){
            System.out.println("Problemas ao cadastrar pessoa! Erro: "+ ex.getMessage());
            ex.printStackTrace();
            return false;
      }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, null);
            }catch (Exception ex){
                System.out.println("Problemas ao fechar os parametros de conexao! Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }        
}
}   

