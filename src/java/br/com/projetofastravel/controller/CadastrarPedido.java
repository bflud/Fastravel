/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.GenericDAO;
import br.com.projetofastravel.DAO.PedidoDAOImpl;
import br.com.projetofastravel.model.Pedido;
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
 * @author Victor
 */
public class CadastrarPedido extends HttpServlet {

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
        String referenciaPedido = request.getParameter("referenciaPedido");
        int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));
        String ruaPedido = request.getParameter("ruaPedido");
        String bairroPedido = request.getParameter("bairroPedido");
        String contatoCliente = request.getParameter("contatoCliente");
        String descricaoPedido = request.getParameter("descricaoPedido");
        Date dataPedido = converterData (request.getParameter("dataPedido").replace("-","/"));
        
        String mensagem = null;
        
        Pedido pedido = new Pedido();
        pedido.setReferenciaPedido(referenciaPedido);
        pedido.setNumeroPedido(numeroPedido);
        pedido.setDescricaoPedido(descricaoPedido);
        pedido.setRuaPedido(ruaPedido);
        pedido.setDataPedido(dataPedido);
        pedido.setContatoCliente(contatoCliente);
        pedido.setBairroPedido(bairroPedido);
        pedido.setStatusPedido("Aguardando");
        pedido.setHorarioChegadaPedido("--:--");
        
        
        try{
            GenericDAO dao = new PedidoDAOImpl();
            if(dao.cadastrar(pedido)){
                mensagem = "Pedido cadastrado com sucesso!";
            }
            else{
                mensagem = "Problemas ao cadastrar pedido!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("profissional/cadastrarpedido.jsp").forward(request, response);
        }
        catch(Exception ex){
            System.out.println("Problemas no servlet. Erro: "+ex.getMessage());
            ex.printStackTrace();
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
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
