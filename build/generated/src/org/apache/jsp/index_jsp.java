package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"img/fa.png\" />\n");
      out.write("        <title>Fastravel</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-responsive.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/grid.css\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <i class=\"glyphicon-home\"></i>\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" class=\"glyphicon-home\" /> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"navbar navbar-fixed-top\">\n");
      out.write("        <div class=\"navbar-inner\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </a>\n");
      out.write("                <a class=\"brand\" href=\"mapadosite.jsp\">FasTravel</a>\n");
      out.write("                <div class=\"nav-collapse\">\n");
      out.write("                    <ul class=\"nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Cliente</a></li>\n");
      out.write("                        <li><a href=\"loginadm.jsp\">Administrador</a></li>\n");
      out.write("                        <li><a href=\"loginprofissional.jsp\">Profissional</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!--/.nav-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("            <div class=\"span12\" id=\"logo\">\n");
      out.write("                <img src=\"img/fatima.png\" id=\"faslogo\"/>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <div id=\"passo1\" class=\"span3\">\n");
      out.write("                <img src=\"img/1.png\" id=\"imgp1\"/>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"seta\" class=\"\">\n");
      out.write("                <i class=\"icon-chevron-right\"></i>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"passo\" class=\"span3\">\n");
      out.write("                <img src=\"img/2.png\" id=\"imgp2\"/>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"seta2\" class=\"\">\n");
      out.write("                <i class=\"icon-chevron-right\"></i>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"passo\" class=\"span3\">\n");
      out.write("                <img src=\"img/3.png\" id=\"imgp3\"/>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"seta3\" class=\"\">\n");
      out.write("                <i class=\"icon-chevron-right\"></i>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"passo\" class=\"span3\">\n");
      out.write("                <img src=\"img/4.png\" id=\"imgp4\"/>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"menu\" class=\"list-group span2\">\n");
      out.write("                <a href=\"#\" class=\"list-group-item active\">\n");
      out.write("                    Empresa \n");
      out.write("                    \n");
      out.write("                </a>\n");
      out.write("                <a href=\"zorropizza.jsp\" class=\"list-group-item\">Zorro Pizza</a>\n");
      out.write("                <img src=\"img/parceiros.gif\" id=\"banner\" alt=\"Parceiros\"/>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"span3\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"span7\" id=\"mapholder\">\n");
      out.write("                <div class=\"control-group input-append input-group-lg\">\n");
      out.write("                    <div id=\"fonte1\"><font color=\"#111\"> Monitore <font color=\"red\">sua</font> entrega<font color=\"red\"> em</font> tempo<font color=\"red\"> real</font></font></div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"form\">\n");
      out.write("                        <br>\n");
      out.write("                        <form action=\"LocalizarEntrega\" method=\"POST\">\n");
      out.write("                            \n");
      out.write("                        <input type=\"text\" id=\"codigo\" name=\"idProfissional\" placeholder=\"Digite o código\"/>\n");
      out.write("                        \n");
      out.write("                        <br><br>\n");
      out.write("                        <center><input type=\"submit\" value=\"Rastrear\" class=\"myButton\"></div></div></center>\n");
      out.write("                        </form>\n");
      out.write("                        <img src=\"img/mapa_google.jpg\" class=\"img-thumbnail\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"span12\" id=\"empresa1\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"rodape\">\n");
      out.write("                <div id=\"copyright\"><p id=\"h3rodape\">Copyright © All Rights Reserved</p></div>\n");
      out.write("                <p id=\"fastravelemail\">Fastravel@outlook.com</h3>\n");
      out.write("                <div id=\"menurodape\">\n");
      out.write("                    <a href=\"#\" class=\"arodape\">Home</a>\n");
      out.write("\n");
      out.write("                    <a href=\"loginadm.jsp\" target=\"aboutblank\" class=\"arodape\">Administrador</a>\n");
      out.write("\n");
      out.write("                    <a href=\"loginprofissional.jsp\" target=\"aboutblank\" class=\"arodape\">Profissional</a>\n");
      out.write("\n");
      out.write("                    <a href=\"mapadosite.jsp\" target=\"aboutblank\" class=\"arodape\">Mapa do Site</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-transition.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-alert.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-modal.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-dropdown.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-scrollspy.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-tab.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-tooltip.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-popover.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-button.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-collapse.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-carousel.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-typeahead.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
