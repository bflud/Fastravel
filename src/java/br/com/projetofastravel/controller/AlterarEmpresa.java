/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofastravel.controller;

import br.com.projetofastravel.DAO.EmpresaDAOImpl;
import br.com.projetofastravel.DAO.GenericDAO;
import br.com.projetofastravel.model.Empresa;
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
public class AlterarEmpresa extends HttpServlet {

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
        String setorComercialEmpresa = request.getParameter("setorComercialEmpresa");
        String statusPessoa = request.getParameter("statusPessoa");
        
        Empresa empresa = new Empresa();
        empresa.setIdPessoa(idPessoa);
        empresa.setNomePessoa(nomePessoa);
        empresa.setCpfCnpj(cpfCnpj);
        empresa.setRgRazaosocial(rgRazaoSocial);
        empresa.setTelefonePessoa(telefonePessoa);
        empresa.setRuaPessoa(ruaPessoa);
        empresa.setNumeroPessoa(numeroPessoa);
        empresa.setBairroPessoa(bairroPessoa);
        empresa.setCidadePessoa(cidadePessoa);
        empresa.setStatusPessoa(statusPessoa);
        empresa.setSetorComercialEmpresa(setorComercialEmpresa);
        
        try{
            GenericDAO dao = new EmpresaDAOImpl();
            if(dao.alterar(empresa)){
                mensagem = "Empresa alterada com sucesso!";
            }
            else{
                mensagem = "Problemas ao alterar empresa!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarEmpresa").forward(request, response);
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
