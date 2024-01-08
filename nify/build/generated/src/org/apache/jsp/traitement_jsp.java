package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.V_Dentition;
import java.util.List;

public final class traitement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    double argent = (Double)request.getAttribute("argent");
    double prixTotal = (Double)request.getAttribute("total");
    double reste = (Double)request.getAttribute("reste");
    List<V_Dentition> dentitions = (List<V_Dentition>)request.getAttribute("dentitions");
    List<V_Dentition> dentitionsChoix = (List<V_Dentition>)request.getAttribute("dentitionsChoix");
    String option = (String)request.getAttribute("option");
    int idPersonne = (Integer)request.getAttribute("idPersonne");


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <h3>Budget ");
      out.print( option );
      out.write(':');
      out.write(' ');
      out.print( argent );
      out.write("</h3>\n");
      out.write("<!--            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    ");
 for(int i=1; i<17; i++) { 
      out.write("\n");
      out.write("                    <td width=\"15\" style=\"background-color: none\"><center>");
      out.print( i );
      out.write("</center></td>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    ");
 for(int i=21; i<37; i++) { 
      out.write("\n");
      out.write("                    <td width=\"15\"><center>");
      out.print( i );
      out.write("</center></td>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </table>-->\n");
      out.write("        </div>\n");
      out.write("                <br/>\n");
      out.write("        <div>\n");
      out.write("            <h2>Propositions: </h2>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Numero</th>\n");
      out.write("                    <th>Etat dent</th>\n");
      out.write("                    <th>Cout traitement</th>\n");
      out.write("                    <th>Cout remplacement</th>\n");
      out.write("                    <th>Cout nettoyage</th>\n");
      out.write("                    <th>Total</th>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                ");
 for(V_Dentition den: dentitions) { 
      out.write("\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td><center>");
      out.print( den.getIdDent() );
      out.write("</center></td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
      out.print( den.getIdEtat() );
      out.write(" \n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
 if(den.getTraitement()!=0) { 
      out.write(' ');
      out.print( den.getTraitement() );
      out.write(' ');
 } 
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
 if(den.getRemplacement()!=0) { 
      out.write(' ');
      out.print( den.getRemplacement() );
      out.write(' ');
 } 
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
 if(den.getNettoyage()!=0) { 
      out.write(' ');
      out.print( den.getNettoyage() );
      out.write(' ');
 } 
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
      out.print( den.getTotal() );
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" name=\"choixDents\" id=\"choixDents\" value=\"\">\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("                <p><strong>Total: </strong>");
      out.print( prixTotal );
      out.write("</p>\n");
      out.write("                <p><strong>Reste: </strong>");
      out.print( reste );
      out.write("</p>\n");
      out.write("                <br/>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <form action=\"TraitementServlet\">\n");
      out.write("                    <input type=\"text\" name=\"idPersonne\" value=\"");
      out.print( idPersonne );
      out.write("\" hidden>\n");
      out.write("                    <input type=\"text\" name=\"argent\" value=\"");
      out.print( argent );
      out.write("\" hidden>\n");
      out.write("                    <input type=\"text\" name=\"option\" value=\"");
      out.print( option );
      out.write("\" hidden>\n");
      out.write("                    <button type=\"submit\">Valider</button>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("<!--            <form action=\"ManambotraServlet\">\n");
      out.write("            <input type=\"hidden\" name=\"idPersonne\" value=\"");
      out.print( idPersonne );
      out.write("\">\n");
      out.write("            <h2>Choisir: </h2>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Numero</th>\n");
      out.write("                    <th>Cout traitement</th>\n");
      out.write("                    <th>Cout remplacement</th>\n");
      out.write("                    <th>Cout nettoyage</th>\n");
      out.write("                    <th>Total</th>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                ");
 for(V_Dentition den: dentitionsChoix) { 
      out.write("\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td><center>");
      out.print( den.getIdDent() );
      out.write("</center></td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
 if (den.getTraitement() <= argent && den.getIdEtat() != 0) { 
      out.write("\n");
      out.write("                                    <label>\n");
      out.write("                                        <input type=\"radio\" onclick=\"calculerSomme(this)\" name=\"");
      out.print( den.getIdDent() );
      out.write("\" value=\"");
      out.print( den.getTraitement() );
      out.write("\"> ");
      out.print( den.getTraitement() );
      out.write("\n");
      out.write("                                    </label>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                ");
 if (den.getRemplacement() <= argent) { 
      out.write("\n");
      out.write("                                    <label>\n");
      out.write("                                        <input type=\"radio\" onclick=\"calculerSomme(this)\" name=\"");
      out.print( den.getIdDent() );
      out.write("\" value=\"");
      out.print( den.getRemplacement() );
      out.write("\"> ");
      out.print( den.getRemplacement() );
      out.write("\n");
      out.write("                                    </label>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" onclick=\"calculerSomme(this)\" name=\"");
      out.print( den.getIdDent() );
      out.write("\" value=\"0\" checked> ");
      out.print( den.getNettoyage() );
      out.write("\n");
      out.write("                                </label>\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" onclick=\"calculerSomme(this)\" name=\"");
      out.print( den.getIdDent() );
      out.write("\" value=\"0\" checked> ");
      out.print( den.getTotal() );
      out.write("\n");
      out.write("                                </label>\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" onclick=\"calculerSomme(this)\" name=\"");
      out.print( den.getIdDent() );
      out.write("\" value=\"0\" checked> Aucun\n");
      out.write("                                </label>\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" name=\"choixDents\" id=\"choixDents\" value=\"\">\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("                <p>\n");
      out.write("                    <button type=\"submit\" onclick=\"obtenirIdsDentsCoches()\" >Valider</button>\n");
      out.write("                </p>\n");
      out.write("            </form>\n");
      out.write("            <p id=\"resultatSomme\"></p>    -->\n");
      out.write("            \n");
      out.write("            <script>\n");
      out.write("                function calculerSomme(clickedRadio) {\n");
      out.write("                    // Récupérer tous les boutons radio cochés\n");
      out.write("                    const radios = document.querySelectorAll('input[type=\"radio\"]:checked');\n");
      out.write("\n");
      out.write("                    // Initialiser la somme\n");
      out.write("                    let somme = 0;\n");
      out.write("                    var argent = ");
      out.print( argent );
      out.write(";\n");
      out.write("\n");
      out.write("                    // Ajouter la valeur de chaque bouton radio à la somme\n");
      out.write("                    radios.forEach(radio => {\n");
      out.write("                        somme += parseFloat(radio.value);\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                   \n");
      out.write("                    // Afficher la somme\n");
      out.write("                    if (somme > argent) {\n");
      out.write("                        // Annuler la sélection de la dernière option cochée\n");
      out.write("                        clickedRadio.checked = false;\n");
      out.write("                    } else {\n");
      out.write("                        // Afficher la somme\n");
      out.write("                        document.getElementById('resultatSomme').textContent = \"Somme : \" + somme;\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                function obtenirIdsDentsCoches() {\n");
      out.write("                    var radiosCoches = document.querySelectorAll('input[type=\"radio\"]:checked');\n");
      out.write("                    var idsDents = \"\";\n");
      out.write("\n");
      out.write("                    radiosCoches.forEach(function(radio) {\n");
      out.write("                        if (radio.value !== \"0\") {\n");
      out.write("                            // Obtenez l'attribut name de la radio\n");
      out.write("                            var idDent = radio.getAttribute('name');\n");
      out.write("\n");
      out.write("                            // Ajoutez l'idDent à la chaîne\n");
      out.write("                            idsDents += idDent + \",\";\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    // Supprimez la virgule finale si elle existe\n");
      out.write("                    idsDents = idsDents.replace(/,$/, '');\n");
      out.write("\n");
      out.write("                    // Mettez à jour la valeur de l'input caché\n");
      out.write("                    document.getElementById('choixDents').value = idsDents;\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
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
