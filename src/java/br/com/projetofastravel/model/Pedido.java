/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Pedido {
    private int idPedido;
    private Date dataPedido;
    private String statusPedido;
    private String horarioChegadaPedido;
    private String referenciaPedido;
    private int numeroPedido;
    private String ruaPedido;
    private String bairroPedido;
    private String contatoCliente;
    private String descricaoPedido;
    private Entrega entrega;

    public Pedido() {
    }

    public Pedido(int idPedido, Date dataPedido, String statusPedido, String horarioChegadaPedido, String referenciaPedido, int numeroPedido, String ruaPedido, String bairroPedido, String contatoCliente, String descricaoPedido, Entrega entrega) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.horarioChegadaPedido = horarioChegadaPedido;
        this.referenciaPedido = referenciaPedido;
        this.numeroPedido = numeroPedido;
        this.ruaPedido = ruaPedido;
        this.bairroPedido = bairroPedido;
        this.contatoCliente = contatoCliente;
        this.descricaoPedido = descricaoPedido;
        this.entrega = entrega;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getHorarioChegadaPedido() {
        return horarioChegadaPedido;
    }

    public void setHorarioChegadaPedido(String horarioChegadaPedido) {
        this.horarioChegadaPedido = horarioChegadaPedido;
    }

    public String getReferenciaPedido() {
        return referenciaPedido;
    }

    public void setReferenciaPedido(String referenciaPedido) {
        this.referenciaPedido = referenciaPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getRuaPedido() {
        return ruaPedido;
    }

    public void setRuaPedido(String ruaPedido) {
        this.ruaPedido = ruaPedido;
    }

    public String getBairroPedido() {
        return bairroPedido;
    }

    public void setBairroPedido(String bairroPedido) {
        this.bairroPedido = bairroPedido;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

   
    
}