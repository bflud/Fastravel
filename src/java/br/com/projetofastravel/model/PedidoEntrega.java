/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.model;

/**
 *
 * @author Aluno
 */
public class PedidoEntrega {
    private Pedido pedido;
    private Entrega entrega;
    private String statusPedidoEntrega;

    public PedidoEntrega() {
    }

    public PedidoEntrega(Pedido pedido, Entrega entrega, String statusPedidoEntrega) {
        this.pedido = pedido;
        this.entrega = entrega;
        this.statusPedidoEntrega = statusPedidoEntrega;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public String getStatusPedidoEntrega() {
        return statusPedidoEntrega;
    }

    public void setStatusPedidoEntrega(String statusPedidoEntrega) {
        this.statusPedidoEntrega = statusPedidoEntrega;
    }        
}
