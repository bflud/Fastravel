/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.AdministradorDAOImpl;
import br.com.projetofastravel.DAO.GenericDAO;
import br.com.projetofastravel.model.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class AlterarAdministrador extends HttpServlet {

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
        
        Integer idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
        String nomeAdministrador = request.getParameter("nomeAdministrador");
        String cpfAdministrador = request.getParameter("cpfAdministrador");
        String emailAdministrador = request.getParameter("emailAdministrador");
        String telefoneAdministrador = request.getParameter("telefoneAdministrador");
        String loginAdministrador = request.getParameter("loginAdministrador");
        String senhaAdministrador = request.getParameter("senhaAdministrador");
        
        String mensagem = null;
        Administrador administrador = new Administrador();
        administrador.setIdAministrador(idAdministrador);
        administrador.setNomeAdministrador(nomeAdministrador);
        administrador.setCpfAdministrador(cpfAdministrador);
        administrador.setEmailAdministrador(emailAdministrador);
        administrador.setTelefoneAdministrador(telefoneAdministrador);
        administrador.setLoginAdministrador(loginAdministrador);
        administrador.setSenhaAdministrador(senhaAdministrador);
        
        try{
            GenericDAO dao = new AdministradorDAOImpl();
            if(dao.alterar(administrador)){
                mensagem = "Administrador alterado com sucesso!";
            }
            else{
                mensagem = "Problemas ao alterar administrador!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarAdministrador").forward(request, response);
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
