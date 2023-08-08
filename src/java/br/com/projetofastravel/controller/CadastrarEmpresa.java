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
public class CadastrarEmpresa extends HttpServlet {

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
        String nomePessoa = request.getParameter("nomePessoa");
        String cpfCnpjPessoa = request.getParameter("cpfCnpjPessoa");
        String rgRazaoSocialPessoa = request.getParameter("rgRazaoSocialPessoa");
        String telefonePessoa = request.getParameter("telefonePessoa");
        String ruaPessoa = request.getParameter("ruaPessoa");
        Integer numeroPessoa = Integer.parseInt(request.getParameter("numeroPessoa"));
        String bairroPessoa = request.getParameter("bairroPessoa");
        String cidadePessoa = request.getParameter("cidadePessoa");
        String setorComercialEmpresa = request.getParameter("setorComercialEmpresa");
        
        String mensagem = null;
        Empresa empresa = new Empresa();
        empresa.setNomePessoa(nomePessoa);
        empresa.setCpfCnpj(cpfCnpjPessoa);
        empresa.setRgRazaosocial(rgRazaoSocialPessoa);
        empresa.setTelefonePessoa(telefonePessoa);
        empresa.setRuaPessoa(ruaPessoa);
        empresa.setNumeroPessoa(numeroPessoa);
        empresa.setBairroPessoa(bairroPessoa);
        empresa.setCidadePessoa(cidadePessoa);
        empresa.setSetorComercialEmpresa(setorComercialEmpresa);
        empresa.setStatusPessoa("Ativo");
        
        try{
            GenericDAO dao = new EmpresaDAOImpl();
            if(dao.cadastrar(empresa)){
                mensagem = "Empresa cadastrada com sucesso!";
            }
            else{
                mensagem = "Problemas ao cadastrar empresa!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("administrador/cadastrarempresa.jsp").forward(request, response);
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
