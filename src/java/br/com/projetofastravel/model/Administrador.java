/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

/**
 *
 * @author Victor
 */
public class Administrador {
    private int idAministrador;
    private String  loginAdministrador;
    private String senhaAdministrador;
    private String emailAdministrador;
    private String telefoneAdministrador;
    private String nomeAdministrador;
    private String cpfAdministrador;

    public Administrador() {
    }

    public Administrador(int idAministrador, String loginAdministrador, String senhaAdministrador, String emailAdministrador, String telefoneAdministrador, String nomeAdministrador, String cpfAdministrador) {
        this.idAministrador = idAministrador;
        this.loginAdministrador = loginAdministrador;
        this.senhaAdministrador = senhaAdministrador;
        this.emailAdministrador = emailAdministrador;
        this.telefoneAdministrador = telefoneAdministrador;
        this.nomeAdministrador = nomeAdministrador;
        this.cpfAdministrador = cpfAdministrador;
    }

    public int getIdAministrador() {
        return idAministrador;
    }

    public void setIdAministrador(int idAministrador) {
        this.idAministrador = idAministrador;
    }

    public String getLoginAdministrador() {
        return loginAdministrador;
    }

    public void setLoginAdministrador(String loginAdministrador) {
        this.loginAdministrador = loginAdministrador;
    }

    public String getSenhaAdministrador() {
        return senhaAdministrador;
    }

    public void setSenhaAdministrador(String senhaAdministrador) {
        this.senhaAdministrador = senhaAdministrador;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }

    public String getTelefoneAdministrador() {
        return telefoneAdministrador;
    }

    public void setTelefoneAdministrador(String telefoneAdministrador) {
        this.telefoneAdministrador = telefoneAdministrador;
    }

    public String getNomeAdministrador() {
        return nomeAdministrador;
    }

    public void setNomeAdministrador(String nomeAdministrador) {
        this.nomeAdministrador = nomeAdministrador;
    }

    public String getCpfAdministrador() {
        return cpfAdministrador;
    }

    public void setCpfAdministrador(String cpfAdministrador) {
        this.cpfAdministrador = cpfAdministrador;
    }

   
    
    
}
