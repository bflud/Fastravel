/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.DAO;

import java.util.List;

/**
 *
 * @author Victor
 */
public interface GenericDAO {
    public Boolean cadastrar(Object object);
    
     public List<Object> listar();
     
    public void excluir(int idObjetc);
    
    public Object carregar(int idObject);
    
    public Boolean alterar(Object object);

}
