package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Personne;
import java.util.List;

public final class accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <a href=\"ToAjoutClientServlet\">Ajouter client</a>\n");
      out.write("    \n");
      out.write("    <form action=\"ToModifServlet\">\n");
      out.write("        Modifier\n");
      out.write("            <select name=\"idPersonne\">\n");
      out.write("                ");
 for(Personne p: personnes) { 
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( p.getIdPersonne() );
      out.write('"');
      out.write('>');
      out.print( p.getPrenom() );
      out.write(' ');
      out.print( p.getNom() );
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <button type=\"submit\">Modifier</button>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    <p>Liste des Patients: </p>\n");
      out.write("    <ul>\n");
      out.write("        ");
 for(Personne pers: personnes) { 
      out.write("\n");
      out.write("        <li><a href=\"ToDetailServlet?idPersonne=");
      out.print( pers.getIdPersonne() );
      out.write('"');
      out.write('>');
      out.print( pers.getPrenom() );
      out.write(' ');
      out.print( pers.getNom() );
      out.write("</li>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("</body>\n");
      out.write("</html>");
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
