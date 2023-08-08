/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.EntregaDAOImpl;
import br.com.projetofastravel.DAO.GenericDAO;
import br.com.projetofastravel.DAO.PedidoEntregaDAOImpl;
import br.com.projetofastravel.model.Entrega;
import br.com.projetofastravel.model.Pedido;
import br.com.projetofastravel.model.PedidoEntrega;
import br.com.projetofastravel.model.Profissional;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CadastrarEntrega extends HttpServlet {

     public Date converterData(String data) throws ParseException{
        if(data != null || !data.trim().equals("")){
            SimpleDateFormat fmt = new SimpleDateFormat ("yyyy/MM/dd");
            return  fmt.parse(data);
        }
        else{
            return null;
        }
    }
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        String horarioSaidaEntrega = request.getParameter("horarioSaidaEntrega");
        Date dataEntrega = converterData (request.getParameter("dataEntrega").replace("-","/"));
        Integer idProfissional = Integer.parseInt(request.getParameter("idProfissional"));
        String mensagem = null;
        
        String [] idPedido = request.getParameterValues("idPedido");
        
        Entrega entrega = new Entrega();
        entrega.setDataEntrega(dataEntrega);
        entrega.setHorarioSaidaEntrega(horarioSaidaEntrega);
        
        Profissional profissional = new Profissional();
        profissional.setIdProfissional(idProfissional);
        entrega.setProfissional(profissional);
        
         try {
            EntregaDAOImpl daoentrega = new EntregaDAOImpl();
            Integer idEntrega = daoentrega.cadastrar(entrega);

            if (idEntrega != null) {
                entrega.setIdEntrega(idEntrega);

                for (int i = 0; i < idPedido.length; i++) {

                    PedidoEntrega pedidoEntrega = new PedidoEntrega();
                    pedidoEntrega.setEntrega(entrega);
                    pedidoEntrega.setStatusPedidoEntrega("A caminho");

                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(Integer.parseInt(String.valueOf(idPedido[i])));
                    pedidoEntrega.setPedido(pedido);

                    GenericDAO daoItem = new PedidoEntregaDAOImpl();
                    if (daoItem.cadastrar(pedidoEntrega)) {
                        mensagem = "Entrega cadastrada com sucesso!";
                    } else {
                        mensagem = "Problemas ao cadastrar a entrega!";
                    }
                }
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosEntrega").forward(request, response);

        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Venda! Erro: " + ex.getMessage());
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(CadastrarEntrega.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(CadastrarEntrega.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
