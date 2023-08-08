/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

/**
 *
 * @author Victor
 */
public class Empresa extends Pessoa{
    private int idEmpresa;
    private String setorComercialEmpresa;

    public Empresa() {
    }

    public Empresa(int idPessoa, String nomePessoa, String cpfCnpj, String rgRazaosocial, String telefonePessoa, String ruaPessoa, int numeroPessoa, String bairroPessoa, String cidadePessoa, String statusPessoa, int idEmpresa, String setorComercialEmpresa) {
        super(idPessoa, nomePessoa, cpfCnpj, rgRazaosocial, telefonePessoa, ruaPessoa, numeroPessoa, bairroPessoa, cidadePessoa, statusPessoa);
        this.idEmpresa = idEmpresa;
        this.setorComercialEmpresa = setorComercialEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getSetorComercialEmpresa() {
        return setorComercialEmpresa;
    }

    public void setSetorComercialEmpresa(String setorComercialEmpresa) {
        this.setorComercialEmpresa = setorComercialEmpresa;
    }

    
}