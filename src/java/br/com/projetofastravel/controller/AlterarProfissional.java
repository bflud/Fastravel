/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.GenericDAO;
import br.com.projetofastravel.DAO.ProfissionalDAOImpl;
import br.com.projetofastravel.model.Profissional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class AlterarProfissional extends HttpServlet {

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
    String mensagem = null;
        Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        String nomePessoa = request.getParameter("nomePessoa");
        String cpfCnpj = request.getParameter("cpfCnpjPessoa");
        String rgRazaoSocial = request.getParameter("rgRazaoSocialPessoa");
        String telefonePessoa = request.getParameter("telefonePessoa");
        String ruaPessoa = request.getParameter("ruaPessoa");
        Integer numeroPessoa = Integer.parseInt(request.getParameter("numeroPessoa"));
        String bairroPessoa = request.getParameter("bairroPessoa");
        String cidadePessoa = request.getParameter("cidadePessoa");
        String loginProfissional = request.getParameter("loginProfissional");
        String senhaProfissional = request.getParameter("senhaProfissional");
        String placaVeiculo = request.getParameter("placaVeiculo");
        String habilitacaoProfissional = request.getParameter("habilitacaoProfissional");
        String statusPessoa = request.getParameter("statusPessoa");
        
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        
        Profissional profissional = new Profissional();
        profissional.setIdPessoa(idPessoa);
        profissional.setNomePessoa(nomePessoa);
        profissional.setCpfCnpj(cpfCnpj);
        profissional.setRgRazaosocial(rgRazaoSocial);
        profissional.setTelefonePessoa(telefonePessoa);
        profissional.setRuaPessoa(ruaPessoa);
        profissional.setNumeroPessoa(numeroPessoa);
        profissional.setBairroPessoa(bairroPessoa);
        profissional.setCidadePessoa(cidadePessoa);
        profissional.setLoginProfissional(loginProfissional);
        profissional.setSenhaProfissional(senhaProfissional);
        profissional.setStatusPessoa(statusPessoa);
        profissional.setPlacaVeiculo(placaVeiculo);
        profissional.setHabilitacaoProfissional(habilitacaoProfissional);
        
        
        try{
            GenericDAO dao = new ProfissionalDAOImpl();
            if(dao.alterar(profissional)){
                mensagem = "Profissional alterado com sucesso!";
            }
            else{
                mensagem = "Problemas ao alterar profissional!";
            }
            request.setAttribute("mensagem", mensagem);
            
            if(tipo == 2){
            request.getRequestDispatcher("ListarProfissional?tipo="+2).forward(request, response);
        }else if(tipo == 1){
            request.getRequestDispatcher("ListarProfissional?tipo="+1).forward(request, response);
        }
            
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
