<%-- 
    Document   : listarprofissional
    Created on : 05/05/2014, 19:27:37
    Author     : Victor
--%>

<%@page import="br.com.projetofastravel.model.Profissional"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<% if (session.getAttribute("idProfissional") != null && session.getAttribute("tipo").equals("profissional") && session.getAttribute("statusPessoa").equals("Ativo")) {%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fastravel - <%= session.getAttribute("nomePessoa") %></title>
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
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="<%= request.getContextPath()%>/#">
                        <i class="icon-user"></i>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%= request.getContextPath()%>/#"><%= session.getAttribute("nomePessoa") %></a></li>
                        <li class="divider"></li>
                        <li>
                            <a href="LogarProfissional?acao=logout">Logout</a>
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
                        <li class=""><a href="LogarAdministrador?acao=logout">Administrador</a></li>
                        <li class="active"><a href="iniciogerente.jsp">Profissional</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" id="logo">
                <img src="<%= request.getContextPath()%>/img/fatima.png" id="faslogo"/>
            </div>
            <div class="menu3">
                <a href="<%= request.getContextPath()%>/DadosProfissional?tipo=<%= 1%>">Cadastrar Profissional</a>
                <a href="<%= request.getContextPath()%>/ListarProfissional?tipo=<%= 1%>" class="current">Listar Profissional</a>
                <a href="<%= request.getContextPath()%>/profissional/cadastrarcargo.jsp">Cadastrar Cargo</a>
                <a href="<%= request.getContextPath()%>/ListarCargo?tipo=<%= 1 %>">Listar Cargo</a>
                <a href="<%= request.getContextPath()%>/profissional/cadastrarpedido.jsp">Cadastrar Pedido</a>
                <a href="<%= request.getContextPath()%>/ListarPedido">Listar Pedido</a>
                <a href="<%= request.getContextPath()%>/DadosEntrega">Cadastrar Entrega</a>
                <a href="<%= request.getContextPath()%>/ListarEntrega">Listar Entrega</a>
            </div>
            <div class="menu3sub">
                <center><h4>${mensagem}</h4><br></center>
                <table align="center" border="0" class="table table-striped table-responsive">
                    <caption>
                        Lista de Profissionais
                    </caption>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>RG</th>
                            <th>Telefone</th>
                            <th>Rua</th>
                            <th>Numero</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
                            <th>Status</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Placa Veiculo</th>
                            <th>Cargo</th>
                            <th colspan="2">Editar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Profissional> profissionais = (List<Profissional>) request.getAttribute("profissionais");
                            for (Profissional profissional : profissionais) {
                        %>    

                        <tr>
                            <td><%= profissional.getIdPessoa()%></td>
                            <td><%= profissional.getNomePessoa()%></td>
                            <td><%= profissional.getCpfCnpj()%></td>
                            <td><%= profissional.getRgRazaosocial()%></td>
                            <td><%= profissional.getTelefonePessoa()%></td>
                            <td><%= profissional.getRuaPessoa()%></td>
                            <td><%= profissional.getNumeroPessoa()%></td>
                            <td><%= profissional.getBairroPessoa()%></td>
                            <td><%= profissional.getCidadePessoa()%></td>
                            <td><%= profissional.getStatusPessoa()%></td>
                            <td><%= profissional.getLoginProfissional()%></td>
                            <td><%= profissional.getSenhaProfissional()%></td>
                            <td><%= profissional.getPlacaVeiculo()%></td>
                            <td><%= profissional.getCargo().getNomeCargo()%></td>
                            <td><a href="ExcluirProfissionalProf?idPessoa=<%=profissional.getIdPessoa()%>">Excluir</a></td>
                            <td><a href="CarregarProfissionalProf?idPessoa=<%=profissional.getIdPessoa()%>">Alterar</a></td>

                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div><br>   
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