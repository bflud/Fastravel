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
public class Entrega {
    private int idEntrega;
    private String horarioSaidaEntrega;
    private Date dataEntrega;
    private Profissional profissional;

    public Entrega() {
    }

    public Entrega(int idEntrega, int notaEntrega, String horarioSaidaEntrega, Date dataEntrega, Profissional profissional) {
        this.idEntrega = idEntrega;
        this.horarioSaidaEntrega = horarioSaidaEntrega;
        this.dataEntrega = dataEntrega;
        this.profissional = profissional;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getHorarioSaidaEntrega() {
        return horarioSaidaEntrega;
    }

    public void setHorarioSaidaEntrega(String horarioSaidaEntrega) {
        this.horarioSaidaEntrega = horarioSaidaEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
    
    
    
}
