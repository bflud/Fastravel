/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

/**
 *
 * @author Victor
 */
public class Pessoa {
    
    private int idPessoa;
    private String nomePessoa;
    private String cpfCnpj;
    private String rgRazaosocial;
    private String telefonePessoa;
    private String ruaPessoa;
    private int numeroPessoa;
    private String bairroPessoa;
    private String cidadePessoa;
    private String statusPessoa;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nomePessoa, String cpfCnpj, String rgRazaosocial, String telefonePessoa, String ruaPessoa, int numeroPessoa, String bairroPessoa, String cidadePessoa, String statusPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfCnpj = cpfCnpj;
        this.rgRazaosocial = rgRazaosocial;
        this.telefonePessoa = telefonePessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa;
        this.bairroPessoa = bairroPessoa;
        this.cidadePessoa = cidadePessoa;
        this.statusPessoa = statusPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgRazaosocial() {
        return rgRazaosocial;
    }

    public void setRgRazaosocial(String rgRazaosocial) {
        this.rgRazaosocial = rgRazaosocial;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getRuaPessoa() {
        return ruaPessoa;
    }

    public void setRuaPessoa(String ruaPessoa) {
        this.ruaPessoa = ruaPessoa;
    }

    public int getNumeroPessoa() {
        return numeroPessoa;
    }

    public void setNumeroPessoa(int numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public String getBairroPessoa() {
        return bairroPessoa;
    }

    public void setBairroPessoa(String bairroPessoa) {
        this.bairroPessoa = bairroPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getStatusPessoa() {
        return statusPessoa;
    }

    public void setStatusPessoa(String statusPessoa) {
        this.statusPessoa = statusPessoa;
    }

    
}
