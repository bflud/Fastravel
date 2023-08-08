<%-- 
    Document   : cadastraradministrador
    Created on : 16/04/2014, 17:08:12
    Author     : Victor
--%>

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
                            <a href="<%= request.getContextPath()%>/LogarAdministrador?acao=logout">Logout</a>                                 
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
                        <li class="active"><a href="<%= request.getContextPath()%>/administrador/inicio.jsp">Administrador</a></li>
                        <li><a href="<%= request.getContextPath()%>/LogarAdministrador?acao=logout">Profissional</a></li>
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
                <a href="<%= request.getContextPath()%>/administrador/cadastraradministrador.jsp" class="current">Cadastrar Administrador</a>
                <a href="<%= request.getContextPath()%>/ListarAdministrador" >Listar Administrador</a>
                <a href="<%= request.getContextPath()%>/administrador/cadastrarempresa.jsp">Cadastrar Empresa</a>
                <a href="<%= request.getContextPath()%>/ListarEmpresa">Listar Empresas</a>
                <a href="<%= request.getContextPath()%>/DadosProfissional?tipo=<%= 2 %>">Cadastrar Profissional</a>
                <a href="<%= request.getContextPath()%>/ListarProfissional?tipo=<%= 2 %>">Listar Profissional</a>
                <a href="<%= request.getContextPath()%>/administrador/cadastrarcargo.jsp">Cadastrar Cargo</a>
                <a href="<%= request.getContextPath()%>/ListarCargo?tipo=<%= 2 %>">Listar Cargo</a>
            </div>
            <div class="menu3sub">
                <center> 
                    <h4> ${mensagem}</h4>
                    <form action="<%= request.getContextPath()%>/CadastrarAdministrador" method="POST">

                        <table id="tablecadastroadm">
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-font"></a></span><input type="text" name="nomeAdministrador" placeholder="Nome" required /></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-barcode"></a></span><input type="text" name="cpfAdministrador" OnKeyPress="return mascaraGenerica(event, this, '###.###.###-##');" required placeholder="CPF (999.999.999-99)"/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-envelope"></a></span><input type="email" name="emailAdministrador" required placeholder="E-mail (email@email.com)"/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-user"></a></span><input type="tel" name="telefoneAdministrador" OnKeyPress="return mascaraGenerica(event, this, '(##)#########');" placeholder="Telefone (99)9999-9999" required/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-ok-sign"></a></span><input type="text" name="loginAdministrador" placeholder="Login" required></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-lock"></a></span><input type="password" name="senhaAdministrador" placeholder="Senha" required></div>
                                    </label>
                                </td>
                            </tr>
                            <br>
                            <tr >
                                <td>
                                   <button type="submit" class="btn btn-default btn-large"><span class="icon-ok-sign"></span>  Cadastrar</button>
                                   <button type="reset" class="btn btn-default btn-large"><span class="icon-remove-sign"></span> Apagar</button>
                                </td>
                            </tr>
                            


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