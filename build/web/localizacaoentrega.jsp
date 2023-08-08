<%-- 
    Document   : localizacaoentrega
    Created on : 23/05/2014, 20:29:18
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetofastravel.model.Profissional"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fastravel</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap-responsive.css" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css" type="text/css"/>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <i class="glyphicon-home"></i>
    <link rel="icon" type="image/png" class="glyphicon-home" /> 
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <div class="btn-group pull-right">
                </div>
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">FasTravel</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active"><a href="<%= request.getContextPath()%>/index.jsp">Cliente</a></li>
                        <li class=""><a href="<%= request.getContextPath()%>/index.jsp">Administrador</a></li>
                        <li class=""><a href="inicio.jsp">Profissional</a></li>
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
            <center><div id="fonte1"><font color="#111"> Monitore <font color="red">sua</font> entrega<font color="red"> em</font> tempo<font color="red"> real</font></font></div></center>

            <form name="inicio" id="inicio" method="POST" action="<%= request.getContextPath()%>/LocalizarEntrega">
                <input type="hidden" value="${posicaoEntrega}" name="posicaoatual" id="posicaoatual" size="50" />
            </form>
            <center>
            <section id="wrapper">
                <header>
                    <h1></h1>
                </header>
                <meta name="viewport" content="width=620" />

                <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
                <article>
                    <p><span id="status"></span></p>
                </article>

                

                <script>
                    function success(position) {
                        var s = document.querySelector('#status');

                        if (s.className == 'success') {
                            // not sure why we're hitting this twice in FF, I think it's to do with a cached result coming back    
                            return;
                        }

                        s.innerHTML = "";
                        s.className = 'success';

                        var mapcanvas = document.createElement('div');
                        mapcanvas.id = 'mapcanvas';
                        mapcanvas.style.height = '500px';
                        mapcanvas.style.width = '660px';

                        document.querySelector('article').appendChild(mapcanvas);
                        //var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                        //alert ('chamou');
                        var latlng = new google.maps.LatLng(-20.2808393, -50.24209250000001);
                        //alert(latlng);
                        
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


                <!--  <script type="text/javascript">
                      window.onload = function() {
                          document.forms.inicio.submit();
                          setTimeout("window.location.reload()", 10000);
                      }                   
                  </script>
                -->
            </section>
            </center>
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

