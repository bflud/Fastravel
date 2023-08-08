<%-- 
    Document   : index
    Created on : 15/04/2014, 13:29:15
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="img/fa.png" />
        <title>Fastravel</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="css/grid.css" type="text/css"/>


    <i class="glyphicon-home"></i>
    <link rel="icon" type="image/png" class="glyphicon-home" /> 
</head>
<body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="mapadosite.jsp">FasTravel</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active"><a href="index.jsp">Cliente</a></li>
                        <li><a href="loginadm.jsp">Administrador</a></li>
                        <li><a href="loginprofissional.jsp">Profissional</a></li>
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
            <br>
            <br>
            <div id="passo1" class="span3">
                <img src="img/1.png" id="imgp1"/>
            </div>
            <div id="seta" class="">
                <i class="icon-chevron-right"></i>
            </div>
            <div id="passo" class="span3">
                <img src="img/2.png" id="imgp2"/>
            </div>
            <div id="seta2" class="">
                <i class="icon-chevron-right"></i>
            </div>
            <div id="passo" class="span3">
                <img src="img/3.png" id="imgp3"/>
            </div>
            <div id="seta3" class="">
                <i class="icon-chevron-right"></i>
            </div>
            <div id="passo" class="span3">
                <img src="img/4.png" id="imgp4"/>
            </div>


            <div id="menu" class="list-group span2">
                <a href="#" class="list-group-item active">
                    Empresa 
                    
                </a>
                <a href="zorropizza.jsp" class="list-group-item">Zorro Pizza</a>
                <img src="img/parceiros.gif" id="banner" alt="Parceiros"/>
            </div>

            <div class="span3">
            </div>

            <div class="span7" id="mapholder">
                <div class="control-group input-append input-group-lg">
                    <div id="fonte1"><font color="#111"> Monitore <font color="red">sua</font> entrega<font color="red"> em</font> tempo<font color="red"> real</font></font></div>
                    <br>
                    <div class="form">
                        <br>
                        <form action="LocalizarEntrega" method="POST">
                            
                        <input type="text" id="codigo" name="idProfissional" placeholder="Digite o código"/>
                        
                        <br><br>
                        <center><input type="submit" value="Rastrear" class="myButton"></div></div></center>
                        </form>
                        <img src="img/mapa_google.jpg" class="img-thumbnail" />
                    </div>
                    <div class="span12" id="empresa1">

                    </div>
                </div>
            </div>
            <div id="rodape">
                <div id="copyright"><p id="h3rodape">Copyright © All Rights Reserved</p></div>
                <p id="fastravelemail">Fastravel@outlook.com</h3>
                <div id="menurodape">
                    <a href="#" class="arodape">Home</a>

                    <a href="loginadm.jsp" target="aboutblank" class="arodape">Administrador</a>

                    <a href="loginprofissional.jsp" target="aboutblank" class="arodape">Profissional</a>

                    <a href="mapadosite.jsp" target="aboutblank" class="arodape">Mapa do Site</a>
                </div>
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
