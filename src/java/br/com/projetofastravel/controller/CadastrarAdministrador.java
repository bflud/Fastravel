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
public class CadastrarAdministrador extends HttpServlet {

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
        
        String loginAdministrador = request.getParameter("loginAdministrador");
        String senhaAdministrador = request.getParameter("senhaAdministrador");
        String emailAdministrador = request.getParameter("emailAdministrador");
        String cpfAdministrador = request.getParameter("cpfAdministrador");
        String nomeAdministrador = request.getParameter("nomeAdministrador");
        String telefoneAdministrador = request.getParameter("telefoneAdministrador");
        
        String mensagem = null;
        Administrador administrador = new Administrador();
        administrador.setLoginAdministrador(loginAdministrador);
        administrador.setSenhaAdministrador(senhaAdministrador);
        administrador.setCpfAdministrador(cpfAdministrador);
        administrador.setNomeAdministrador(nomeAdministrador);
        administrador.setTelefoneAdministrador(telefoneAdministrador);
        administrador.setEmailAdministrador(emailAdministrador);
        
        try{
            GenericDAO dao = new AdministradorDAOImpl();
            if(dao.cadastrar(administrador)){
                mensagem = "Administrador cadastrado com sucesso!";
            }
            else{
                mensagem = "Problemas ao cadastrar administrador!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("administrador/cadastraradministrador.jsp").forward(request, response);
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
