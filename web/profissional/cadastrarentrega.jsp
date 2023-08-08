[<%-- 
    Document   : cadastrarentrega
    Created on : 12/05/2014, 17:23:51
    Author     : Victor
--%>

<%@page import="br.com.projetofastravel.model.Pedido"%>
<%@page import="br.com.projetofastravel.model.Profissional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="icon" type="image/png" class="glyphicon-home" /> <script type="text/javascript">
        <%-- Função que clona a div CLONE quando clicar no botão BTNPOSITIVO aparecendo antes da div APARECERCLONE--%>
            function  clonar() {
                $("#clone").clone().prependTo($("#aparecerClone"));
            }
            ;
        <%-- Função que remove a div CLONE quando clicar no botão BTNNEGATIVO--%>
            function removerclone() {
                $("#clone").remove();
            }
            ;
    </script> 

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
                        <li><a href="#"><%= session.getAttribute("nomePessoa") %></a></li>
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
                <img src="<%= request.getContextPath()%>/img/fatima.png" class="img span3" id="faslogo"/>
            </div>

            <div class="menu3">
                <a href="<%= request.getContextPath()%>/DadosProfissional?tipo=<%= 1%>">Cadastrar Profissional</a>
                <a href="<%= request.getContextPath()%>/ListarProfissional?tipo=<%= 1%>">Listar Profissional</a>
                <a href="<%= request.getContextPath()%>/profissional/cadastrarcargo.jsp" >Cadastrar Cargo</a>
                <a href="<%= request.getContextPath()%>/ListarCargo?tipo=<%= 1 %>">Listar Cargo</a>
                <a href="<%= request.getContextPath()%>/profissional/cadastrarpedido.jsp">Cadastrar Pedido</a>
                <a href="<%= request.getContextPath()%>/ListarPedido">Listar Pedido</a>
                <a href="<%= request.getContextPath()%>/DadosEntrega"  class="current">Cadastrar Entrega</a>
                <a href="<%= request.getContextPath()%>/ListarEntrega">Listar Entrega</a>
            </div>
            <div class="menu3sub">
                <center><h4>${mensagem}</h4><br><br>
                <form action="<%= request.getContextPath()%>/CadastrarEntrega" method="POST">
                    <table>
                        <tr>
                            <td>
                                <label>
                                    <div class="input-prepend input-group-lg    "><span class="add-on"><a class="icon-time"></a></span><input type="text" name="horarioSaidaEntrega" placeholder="Horario de Saida" OnKeyPress="return mascaraGenerica(event, this, '##:##');" required/></div>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>
                                    <div class="input-prepend input-group-lg    "><span class="add-on"><a class="icon-calendar"></a></span><input type="date"name="dataEntrega" required/></div>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><div class="input-prepend input-group-lg    "><span class="add-on"><a class="icon-briefcase"></a></span>
                                    <select name="idProfissional" >
                                        <option>-- Profissional --</option>
                                        <%
                                            List<Profissional> profissionais = (List<Profissional>) request.getAttribute("profissionais");
                                            for (Profissional profissional : profissionais) {
                                        %>
                                        <option value ="<%=profissional.getIdProfissional()%>">  <%=profissional.getNomePessoa()%> </option>        
                                        <%}%>
                                    </select></div>
                                </label>
                            </td>
                        </tr>                   
                    </table>
                                    
                            <td>Pedidos  <button type="button" id="btnPositivo" class="btn btn-default " onClick="clonar();"><span class="icon-plus-sign"></span></button>
                               <button type="button" id="btnNegativo" class="btn btn-default " onClick="removerclone();"><span class="icon-minus-sign"></span></button>
                            <br><br>
                    <div id="clone">
                        <label>
                            <div class="input-prepend input-group-lg    "><span class="add-on"><a class="icon-list"></a></span>
                            <select name="idPedido">
                                <option>-- Pedido --</option>
                                <%
                                    List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
                                    for (Pedido pedido : pedidos) {
                                %>
                                <option value ="<%=pedido.getIdPedido()%>">  <%=pedido.getDescricaoPedido()%> </option>        
                                <%}%>
                            </select>
                        </label></div>
                        <hr>
                    </div>
                    <div id="aparecerClone">
                    </div>
                    <button type="submit" class="btn btn-default btn-large"><span class="icon-ok-sign"></span>  Cadastrar</button>

                </form>
                </center>


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