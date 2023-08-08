<%-- 
    Document   : inicio
    Created on : 05/05/2014, 14:44:40
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("idProfissional") != null && session.getAttribute("tipo").equals("profissional") && session.getAttribute("statusPessoa").equals("Ativo")) {%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fastravel - <%= session.getAttribute("nomePessoa")%></title>
        <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/fa.png" />
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap-responsive.css" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css" type="text/css"/>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <i class="glyphicon-home"></i>
    <link rel="icon" type="image/png" class="glyphicon-home" />

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

    <script>
        function success(position) {
            var s = document.querySelector('#status');

            if (s.className == 'success') {
                // not sure why we're hitting this twice in FF, I think it's to do with a cached result coming back    
                return;
            }

            s.innerHTML = "Você está aqui!";
            s.className = 'success';

            var mapcanvas = document.createElement('div');
            mapcanvas.id = 'mapcanvas';
            mapcanvas.style.height = '500px';
            mapcanvas.style.width = '660px';

            document.querySelector('article').appendChild(mapcanvas);

            //latlng = document.getElementById('posicaoatual').value; 
            var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            var myOptions = {
                zoom: 17,
                center: latlng,
                mapTypeControl: false,
                navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("mapcanvas"), myOptions);

            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                title: "Sua entrega esta aqui!"
            });

            document.getElementById('posicaoatual').value = latlng;

        }

        function error(msg) {
            var s = document.querySelector('#status');
            s.innerHTML = typeof msg == 'string' ? msg : "failed";
            s.className = 'fail';

            // console.log(arguments);
        }

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(success, error);
        } else {
            error('not supported');
        }
    </script>    

</head>
<body  onload="enviar()">

    <div class="navbar navbar-fixed-top" >
        <div class="navbar-inner">
            <div class="container-fluid">
                <div class="btn-group pull-right">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="icon-user"></i>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><%= session.getAttribute("nomePessoa")%></a></li>
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
                        <li class=""><a href="<%= request.getContextPath()%>/LogarProfissional?acao=logout">Cliente</a></li>
                        <li class=""><a href="<%= request.getContextPath()%>/LogarProfissional?acao=logout">Administrador</a></li>
                        <li class="active"><a href="inicio.jsp">Profissional</a></li>
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
            <center>

                <section id="wrapper">
                    <header>
                        <h1>geolocation</h1>
                    </header>
                    <meta name="viewport" content="width=620" />

                    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
                    <article>
                        <p><span id="status">Rastreando...</span></p>
                    </article>

                    <form name="inicio" id="inicio" method="POST" action="<%= request.getContextPath()%>/AtualizarPosicao?idProfissional=<%= session.getAttribute("idProfissional")%>">
                        <input type="hidden" value="" name="posicaoatual" id="posicaoatual" size="50" />
                        
                    </form>
                    <!-- 10000 --> 

                </section>
            </center>
        </div>
    </div>   
    

</body>    

</html>

<% } else {
        response.sendRedirect("/ProjetoFastravel/loginprofissional.jsp");
    }
%> 