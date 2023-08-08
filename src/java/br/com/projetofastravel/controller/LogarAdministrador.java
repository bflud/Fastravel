/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.AdministradorDAOImpl;
import br.com.projetofastravel.model.Administrador;
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
public class LogarAdministrador extends HttpServlet {

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
        Administrador administrador = null;
        String mensagem = null;
        String nomeAdm = null;
        
        if(request.getParameter("acao").equals("logar")){
            if(!login.equals("") || !senha.equals("")){
                try{
                    AdministradorDAOImpl daoAdministrador = new AdministradorDAOImpl();
                    administrador = daoAdministrador.verificarUsuario(login, senha);
                    if(administrador != null){
                     HttpSession session = request.getSession(true);
                     session.setAttribute("idAdministrador", administrador.getIdAministrador());
                     session.setAttribute("loginAdministrador", administrador.getLoginAdministrador());
                     session.setAttribute("senhaAdministrador", administrador.getSenhaAdministrador());
                     session.setAttribute("nomeAdministrador", administrador.getNomeAdministrador());
                     session.setAttribute("tipo", tipo);
                     
                     mensagem = "Seja Bem vindo Sr(a) " + administrador.getNomeAdministrador()+ "!";
                     nomeAdm = administrador.getNomeAdministrador();
                     session.setAttribute("mensagem", mensagem);                     
                     session.setAttribute("nomeAdm", nomeAdm);  
                     if(tipo.equals("administrador")){
                         request.getRequestDispatcher("administrador/inicio.jsp").forward(request, response);
                         nomeAdm = administrador.getLoginAdministrador();
                     }
                    }
                    else{
                        mensagem = "Usuario ou senha invalidos";
                        request.setAttribute("errologin", mensagem);
                        request.getRequestDispatcher("loginadm.jsp").forward(request, response);
                    }
                } catch(Exception ex){
                    System.out.println("Problemas no servlet ao Logar Usuario! Erro: "+ex.getMessage());
                    ex.printStackTrace();
                }
            }else{
                mensagem = "Usuario ou senha invalidos!";
                request.setAttribute("errologin", mensagem);
                request.getRequestDispatcher("loginadm.jsp").forward(request, response);
            }
        } else if(request.getParameter("acao").equals("logout")){
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("loginadm.jsp");
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
