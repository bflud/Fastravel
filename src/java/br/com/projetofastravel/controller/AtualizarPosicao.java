/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.ProfissionalDAOImpl;
import br.com.projetofastravel.model.Profissional;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrey
 */
public class AtualizarPosicao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        String posicaoatual = request.getParameter("posicaoatual");
        System.out.println("P: " + posicaoatual);
        Integer idProfissional = Integer.parseInt(request.getParameter("idProfissional"));
        System.out.println("id: " + idProfissional);
        String mensagem = null;
        
        Profissional profissional = new Profissional();
        profissional.setPosicaoAtual(posicaoatual);
        profissional.setIdProfissional(idProfissional);
            
        try{
            ProfissionalDAOImpl dao = new ProfissionalDAOImpl();
            if(dao.atualizarPosicao(profissional)){
                mensagem = "Atualizou a posicao: "+posicaoatual;
            }
            else{
                mensagem = "Problemas ao alterar posicao!";
            }
            request.setAttribute("mensagem", mensagem);
            System.out.println(mensagem);
            request.getRequestDispatcher("profissional/inicioentregador.jsp").forward(request, response);
            
        }
        catch(Exception ex){
            System.out.println("Problemas no servlet. Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
