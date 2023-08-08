/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.ProfissionalDAOImpl;
import br.com.projetofastravel.model.Cargo;
import br.com.projetofastravel.model.Profissional;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor
 */
public class LogarProfissional extends HttpServlet {

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
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");        
        String tipo = request.getParameter("tipo");
        Profissional profissional = null;
        Cargo cargo = null;
        String mensagem = null;
        
        
        if(request.getParameter("acao").equals("logar")){
            if(!login.equals("") || !senha.equals("")){
                try{
                    ProfissionalDAOImpl daoProfissional = new ProfissionalDAOImpl();
                    profissional = daoProfissional.verificarUsuario(login, senha);
                    if(profissional != null){
                     HttpSession session = request.getSession(true);
                     session.setAttribute("idProfissional", profissional.getIdProfissional());
                     session.setAttribute("nomePessoa", profissional.getNomePessoa());
                     session.setAttribute("cpfCnpj", profissional.getCpfCnpj());
                     session.setAttribute("statusPessoa", profissional.getStatusPessoa());
                     session.setAttribute("placaVeiculo", profissional.getPlacaVeiculo());
                     session.setAttribute("habilitacaoProfissional", profissional.getHabilitacaoProfissional());
                     session.setAttribute("cargo", profissional.getCargo().getIdCargo());
                     session.setAttribute("nomeCargo", profissional.getCargo().getNomeCargo());
                     session.setAttribute("statusPessoa", profissional.getStatusPessoa());
                     session.setAttribute("tipo", tipo);
                     
                     mensagem = "Seja Bem vindo Sr(a) " + profissional.getNomePessoa()+ "!";
                     session.setAttribute("mensagem", mensagem);                     
                     if(profissional.getCargo().getNomeCargo().equals("Gerente")){
                         request.getRequestDispatcher("profissional/iniciogerente.jsp").forward(request, response);
                     }
                     else if(profissional.getCargo().getNomeCargo().equals("Entregador")){
                         request.getRequestDispatcher("profissional/inicioentregador.jsp").forward(request, response);
                     }
                    }
                    else{
                        mensagem = "Usuario ou senha invalidos";
                        request.setAttribute("errologin", mensagem);
                        request.getRequestDispatcher("loginprofissional.jsp").forward(request, response);
                    }
                } catch(Exception ex){
                    System.out.println("Problemas no servlet ao Logar Usuario! Erro: "+ex.getMessage());
                    ex.printStackTrace();
                }
            }else{
                mensagem = "Usuario ou senha invalidos!";
                request.setAttribute("errologin", mensagem);
                request.getRequestDispatcher("loginprofissional.jsp").forward(request, response);
            }
        } else if(request.getParameter("acao").equals("logout")){
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("loginprofissional.jsp");
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
        processRequest(request, response);
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
