/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

/**
 *
 * @author Victor
 */
public class Profissional extends Pessoa{
    private int idProfissional;
    private String placaVeiculo;
    private String habilitacaoProfissional;
    private String loginProfissional;
    private String senhaProfissional;
    private Cargo cargo;
    private Empresa empresa;
    private String posicaoAtual;
    

    public Profissional() {
    }

    public Profissional(int idPessoa, String nomePessoa, String cpfCnpj, String rgRazaosocial, String telefonePessoa, String ruaPessoa, int numeroPessoa, String bairroPessoa, String cidadePessoa, String statusPessoa, int idProfissional, String placaVeiculo, String habilitacaoProfissional, String loginProfissional, String senhaProfissional, Cargo cargo, Empresa empresa, String posicaoAtual) {
        super(idPessoa, nomePessoa, cpfCnpj, rgRazaosocial, telefonePessoa, ruaPessoa, numeroPessoa, bairroPessoa, cidadePessoa, statusPessoa);
        this.idProfissional = idProfissional;
        this.placaVeiculo = placaVeiculo;
        this.habilitacaoProfissional = habilitacaoProfissional;
        this.loginProfissional = loginProfissional;
        this.senhaProfissional = senhaProfissional;
        this.cargo = cargo;
        this.empresa = empresa;
        this.posicaoAtual = posicaoAtual;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getHabilitacaoProfissional() {
        return habilitacaoProfissional;
    }

    public void setHabilitacaoProfissional(String habilitacaoProfissional) {
        this.habilitacaoProfissional = habilitacaoProfissional;
    }

    public String getLoginProfissional() {
        return loginProfissional;
    }

    public void setLoginProfissional(String loginProfissional) {
        this.loginProfissional = loginProfissional;
    }

    public String getSenhaProfissional() {
        return senhaProfissional;
    }

    public void setSenhaProfissional(String senhaProfissional) {
        this.senhaProfissional = senhaProfissional;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(String posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
    
    
 
}
