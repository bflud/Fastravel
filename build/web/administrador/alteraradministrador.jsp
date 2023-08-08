<%-- 
    Document   : alteraradministrador
    Created on : 07/05/2014, 16:35:50
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
                <img src="<%= request.getContextPath()%>/img/fatima.png"  id="faslogo"/>
            </div>
            <div class="menu3subalterar">
                <center> <div id="alteraradm">
                <form action="<%= request.getContextPath()%>/AlterarAdministrador" method="POST">
                    <h2>Alterar Administrador</h2>
                      <table id="tablecadastroadm">
                            <tr>
                              <td>
                                  <label>
                                      <div class="input-prepend input-group-lg"><span class="add-on"><b>ID</b></span><input type="text" name="idAdministrador" readonly="" value="${administrador.idAministrador}"/></div>
                                  </label>
                              </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-font"></a></span><input type="text" name="nomeAdministrador" value="${administrador.nomeAdministrador}" required /></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-barcode"></a></span><input type="text" name="cpfAdministrador" OnKeyPress="return mascaraGenerica(event, this, '###.###.###-##');" required value="${administrador.cpfAdministrador}"/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-envelope"></a></span><input type="email" name="emailAdministrador" required value="${administrador.emailAdministrador}"/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-user"></a></span><input type="tel" name="telefoneAdministrador" OnKeyPress="return mascaraGenerica(event, this, '(##)#########');" value="${administrador.telefoneAdministrador}" required/></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-ok-sign"></a></span><input type="text" name="loginAdministrador" value="${administrador.loginAdministrador}" required></div>
                                    </label>
                                </td>
                            </tr>
                            <br>

                            <tr>
                                <td>
                                    <label>
                                        <div class="input-prepend input-group-lg"><span class="add-on"><a class="icon-lock"></a></span><input type="password" name="senhaAdministrador" value="${administrador.senhaAdministrador}" required></div>
                                    </label>
                                </td>
                            </tr>
                            <br>
                            <tr>
                                <td>
                                   <button type="submit" class="btn btn-default btn-large"><span class="icon-ok-sign"></span>  Alterar</button>
                                   <button type="reset" class="btn btn-default btn-large"><span class="icon-remove-sign"></span> Apagar</button>
                                </td>
                            </tr>
                            
                            <br>


                        </table>
                </form>
                    </div></center></div>
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