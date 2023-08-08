<%-- 
    Document   : alterarprofissional
    Created on : 05/05/2014, 20:35:57
    Author     : Victor
--%>

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
                        <li><a href="#"><%= session.getAttribute("nomePessoa") %></a></li>
                        <li class="divider"></li>
                        <li>
                            <a href="LogarEmpresa?acao=logout">Logout</a>
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

            <h1>Cadastro de Profissional</h1>
            <form action="<%= request.getContextPath()%>/AlterarProfissional?tipo=<%= 1 %>" method="POST">

                <table border="1">
                    <tr>
                        <td>ID: </td>
                        <td><input type="text" readonly="" name="idPessoa"  required value="${profissional.idPessoa}"/></td>			
                    </tr>
                    <tr>
                        <td>Nome: </td>
                        <td><input type="text" name="nomePessoa" id="nome" required value="${profissional.nomePessoa}"/></td>			
                    </tr>
                    <tr>		
                        <td>CPF: </td>
                        <td><input type="text" name="cpfCnpjPessoa" id="cpfCnpjPessoa" required value="${profissional.cpfCnpj}"/></td>			
                    </tr>
                    <tr>
                        <td>RG: </td>
                        <td><input type="text" name="rgRazaoSocialPessoa" id="rgRazaoSocialPessoa" required value="${profissional.rgRazaosocial}"/></td>			
                    </tr>
                    <tr>			
                        <td>Telefone: </td>
                        <td><input type="tel" name="telefonePessoa" id="telefonePessoa" required value="${profissional.telefonePessoa}" /></td>			
                    </tr>
                    <tr>			
                        <td>Rua: </td>
                        <td><input type="text" name="ruaPessoa" id="ruaPessoa" required value="${profissional.ruaPessoa}"/></td>			
                    </tr>
                    <tr>			
                        <td>Número: </td>
                        <td><input type="text" name="numeroPessoa" id="numeroPessoa" required value="${profissional.numeroPessoa}"/></td>			
                    </tr>
                    <tr>			
                        <td>Bairro: </td>
                        <td><input type="text" name="bairroPessoa" id="bairroPessoa" required value="${profissional.bairroPessoa}"/></td>			
                    </tr>
                    <tr>			
                        <td>Cidade: </td>
                        <td><input type="text" name="cidadePessoa" id="cidadePessoa" required value="${profissional.cidadePessoa}"/></td>			
                    </tr>
                    <tr>			
                        <td>Login: </td>
                        <td><input type="text" name="loginPessoa" id="loginPessoa" required value="${profissional.loginProfissional}" /></td>			
                    </tr>
                    <tr>			
                        <td>Senha: </td>
                        <td><input type="password" name="senhaPessoa" id="senhaPessoa" required value="${profissional.senhaProfissional}"/></td>			
                    </tr>      
                    <tr>			
                        <td>Placa Veiculo: </td>
                        <td><input type="text" name="placaVeiculo" id="placaVeiculo" required value="${profissional.placaVeiculo}" /></td>                       
                    </tr>                
                    <tr>			
                        <td>Habilitação Profissional: </td>
                        <td><input type="text" name="habilitacaoProfissional" id="habilitacaoProfissional" required value="${profissional.habilitacaoProfissional}" /></td>                       
                    </tr>             
                    <tr>			
                        <td>Status: </td>
                        <td><select name="statusPessoa">
                                <option>Ativo</option>
                                <option>Inativo</option>
                            </select>
                        </td>                       
                    </tr>
                    <tr>
                        <td><input type="submit" value="Enviar" class="btn"/></td>
                        <td><input type="reset" value="Limpar" name="limpar" class="btn" /></td>
                    </tr>

                    <br>


                </table>
            </form> <a href="inicio.jsp">Voltar</a>
        </div>

    </div>
</div>    <br>
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