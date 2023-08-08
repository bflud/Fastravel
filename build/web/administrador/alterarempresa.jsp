<%-- 
    Document   : alterarempresa
    Created on : 10/05/2014, 14:03:53
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
                <img src="<%= request.getContextPath()%>/img/fatima.png" class="img span3" id="faslogo"/>
            </div>
            <div class="menu3subalterar">
                <center><h2>Alterar Empresa</h2>
                <form action="<%= request.getContextPath()%>/AlterarEmpresa" method="POST" class="form-group">
                    <table>
                        <tr>
                            <td>
                                <label>
                                    <div class="input-prepend input-group-lg"><span class="add-on"><b>ID</b></span><input type="text" readonly="" name="idPessoa" required value="${empresa.idPessoa}"/></div>
                                </label>
                            </td>
                        </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-font"></a></span><input type="text" name="nomePessoa" required value="${empresa.nomePessoa}"/></div>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-barcode"></a></span><input type="text" name="cpfCnpjPessoa" placeholder="Cnpj (11.111.111/1111-11)" onkeypress="return mascaraGenerica(event, this, '##.###.###/####-##');" value="${empresa.cpfCnpj}" required /></div>
                                    </label>
                                </td>
                            </tr>
                            <br>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-tag"></a></span><input type="text" name="rgRazaoSocialPessoa" required value="${empresa.rgRazaosocial}"/></div>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-user"></a></span><input type="text" name="telefonePessoa" value="${empresa.telefonePessoa}" placeholder="Tel (99)9999-9999" onkeypress="return mascaraGenerica(event, this, '(##)#########');" required /></div>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-road"></a></span><input type="text" name="ruaPessoa" required value="${empresa.ruaPessoa}"/></div>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-home"></a></span><input type="number" name="numeroPessoa" required value="${empresa.numeroPessoa}"/></div>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-th-large"></a></span><input type="text" name="bairroPessoa" required value="${empresa.bairroPessoa}"/></div>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-screenshot"></a></span><input type="text" name="cidadePessoa" required value="${empresa.cidadePessoa}"/></div>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-briefcase"></a></span><input type="text" name="setorComercialEmpresa" required value="${empresa.setorComercialEmpresa}"/></div>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-edit"></a></span>
                                    <select name="statusPessoa">
                                        <option>Ativo</option>
                                        <option>Inativo</option>
                                    </select></div>
                                </td>
                            </tr>
                            <tr >
                                <td>
                                   <button type="submit" class="btn btn-default btn-large"><span class="icon-ok-sign"></span>  Alterar</button>
                                   <button type="reset" class="btn btn-default btn-large"><span class="icon-remove-sign"></span> Apagar</button>
                                </td>
                            </tr>


                        </table>
                        
                </form>
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
    </div>F

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