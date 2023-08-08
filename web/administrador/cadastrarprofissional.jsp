<%-- 
    Document   : cadastrarprofissional
    Created on : 30/04/2014, 15:13:53
    Author     : Victor
--%>

<%@page import="br.com.projetofastravel.model.Cargo"%>
<%@page import="br.com.projetofastravel.model.Empresa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("idAdministrador") != null && session.getAttribute("tipo").equals("administrador")) {%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fastravel - <%= session.getAttribute("nomeAdministrador") %></title>
        <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/fa.png" />
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap-responsive.css" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css" type="text/css"/>
    <i class="glyphicon-home"></i>
    <link rel="icon" type="image/png" class="glyphicon-home" /> 
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <div class="btn-group pull-right">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="icon-user"></i>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><%= session.getAttribute("nomeAdministrador") %></a></li>
                        <li class="divider"></li>
                        <li>
                            <a href="LogarAdministrador?acao=logout">Logout</a>
                        </li>
                    </ul>
                </div>
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">FasTravel</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class=""><a href="index.jsp">Cliente</a></li>
                        <li class="active"><a href="administrador/inicio.jsp">Administrador</a></li>
                        <li><a href="LogarAdministrador?acao=logout">Profissional</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" id="logo">
                <img src="img/fatima.png" id="faslogo"/>
            </div>


            <div class="menu3">
                <a href="<%= request.getContextPath()%>/administrador/cadastraradministrador.jsp">Cadastrar Administrador</a>
                <a href="<%= request.getContextPath()%>/ListarAdministrador" >Listar Administrador</a>
                <a href="<%= request.getContextPath()%>/administrador/cadastrarempresa.jsp">Cadastrar Empresa</a>
                <a href="<%= request.getContextPath()%>/ListarEmpresa">Listar Empresas</a>
                <a href="<%= request.getContextPath()%>/DadosProfissional?tipo=<%= 2 %>" class="current">Cadastrar Profissional</a>
                <a href="<%= request.getContextPath()%>/ListarProfissional?tipo=<%= 2 %>">Listar Profissional</a>
                <a href="<%= request.getContextPath()%>/administrador/cadastrarcargo.jsp">Cadastrar Cargo</a>
                <a href="<%= request.getContextPath()%>/ListarCargo?tipo=<%= 2 %>">Listar Cargo</a>
            </div>
            <div class="menu3sub maior">
                <div id="cadastroprofissional">
                    <center><h4>${mensagem}</h4><br>
                    <form action="<%= request.getContextPath()%>/CadastrarProfissional?tipo=<%= 2 %>" method="POST" class="form-group">

                        <table>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-font"></a></span><input type="text" name="nomePessoa" id="nome" required placeholder="Nome"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-barcode"></a></span><input type="text" name="cpfCnpjPessoa" id="cpfCnpjPessoa" OnKeyPress="return mascaraGenerica(event, this, '###.###.###-##');" required placeholder="CPF (999.999.999-99)" /></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-list-alt"></a></span><input type="text" name="rgRazaoSocialPessoa" id="rgRazaoSocialPessoa" OnKeyPress="return mascaraGenerica(event, this, '##.###.###-##');" required placeholder="RG (99.999.999-99)"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-user"></a></span><input type="tel" name="telefonePessoa" id="telefonePessoa" OnKeyPress="return mascaraGenerica(event, this, '(##)#########');" required placeholder="Tel (99)99999-9999"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>	
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-road"></a></span><input type="text" name="ruaPessoa" id="ruaPessoa" required placeholder="Rua"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-home"></a></span><input type="text" name="numeroPessoa" id="numeroPessoa" required placeholder="Nº"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-th-large"></a></span><input type="text" name="bairroPessoa" id="bairroPessoa" required placeholder="Bairro"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-screenshot"></a></span><input type="text" name="cidadePessoa" id="cidadePessoa" required placeholder="Cidade"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-ok"></a></span><input type="text" name="loginProfissional" id="loginProfissional" required placeholder="Login"/></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-lock"></a></span><input type="password" name="senhaProfissional" id="senhaProfissional" required placeholder="Senha"/></div>
                                    </label>
                                </td>			
                            </tr>                
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-tags"></a></span><input type="text" name="placaVeiculo" id="placaVeiculo" placeholder="Placa (ABC-1234)"required /></div>
                                    </label>
                                </td>                       
                            </tr>                
                            <tr>			
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-book"></a></span><input type="text" name="habilitacaoProfissional" id="habilitacaoProfissional" placeholder="Carteira de habilitação" required /></div>
                                    </label>
                                </td>                       
                            </tr>
                            <tr>			
                                <td>
                                    <label><div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-list"></a></span>
                                        <select name="idEmpresa">
                                            <%
                                                List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
                                                for (Empresa empresa : empresas) {
                                            %>
                                            <option value ="<%=empresa.getIdEmpresa()%>">  <%=empresa.getRgRazaosocial()%> </option>        
                                            <%}%>
                                        </select></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr>			
                                <td>
                                    <label><div class="input-prepend input-group-lg"><span class="add-on "><a class="icon-briefcase"></a></span>
                                        <select name="idCargo">
                                        <%
                                            List<Cargo> cargos = (List<Cargo>) request.getAttribute("cargos");
                                            for (Cargo cargo : cargos) {
                                        %>
                                        <option value ="<%=cargo.getIdCargo()%>">  <%=cargo.getNomeCargo()%> </option>        
                                        <%}%>
                                        </select></div>
                                    </label>
                                </td>			
                            </tr>
                            <tr >
                                <td>
                                   <button type="submit" class="btn btn-default btn-large"><span class="icon-ok-sign"></span>  Cadastrar</button>
                                   <button type="reset" class="btn btn-default btn-large"><span class="icon-remove-sign"></span> Apagar</button>
                                </td>
                            </tr>

                            <br>


                        </table>
                    </form>
                    </center>
                </div>
            </div>

        </div>
    </div>
                                    <br>
    <div id="rodape">
        <div id="copyright"><p id="h3rodape">Copyright © All Rights Reserved</p></div>

        <p id="fastravelemail">Fastravel@outlook.com</h3>
        <div id="menurodape">
            <a href="#" class="arodape">Home</a>

            <a href="loginadm.jsp" target="aboutblank" class="arodape">Administrador</a>

            <a href="loginprofissional.jsp" target="aboutblank" class="arodape">Profissional</a>

            <a href="#" target="aboutblank" class="arodape">Mapa do Site</a>
        </div>
    </div>
    <script language="JavaScript" type="text/javascript">
        function mascaraGenerica(evt, campo, padrao) {
            //testa a tecla pressionada pelo usuario  
            var charCode = (evt.which) ? evt.which : evt.keyCode;
            if (charCode == 8)
                return true; //tecla backspace permitida  
            if (charCode != 46 && (charCode < 48 || charCode > 57))
                return false; //apenas numeros            
            campo.maxLength = padrao.length; //Define dinamicamente o tamanho maximo do campo de acordo com o padrao fornecido  
            //aplica a mascara de acordo com o padrao fornecido  
            entrada = campo.value;
            if (padrao.length > entrada.length && padrao.charAt(entrada.length) != '#') {
                campo.value = entrada + padrao.charAt(entrada.length);
            }
            return true;
        }
    </script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>
</body>
</html>

<% } else {
        response.sendRedirect("../index.jsp");
    }
%>