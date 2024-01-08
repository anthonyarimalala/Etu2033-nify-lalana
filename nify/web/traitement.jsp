
<%@page import="model.V_Dentition"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    double argent = (Double)request.getAttribute("argent");
    double prixTotal = (Double)request.getAttribute("total");
    double reste = (Double)request.getAttribute("reste");
    List<V_Dentition> dentitions = (List<V_Dentition>)request.getAttribute("dentitions");
    List<V_Dentition> dentitionsChoix = (List<V_Dentition>)request.getAttribute("dentitionsChoix");
    String option = (String)request.getAttribute("option");
    int idPersonne = (Integer)request.getAttribute("idPersonne");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Budget <%= option %>: <%= argent %></h3>
<!--            <table border="1">
                <tr>
                    <% for(int i=1; i<17; i++) { %>
                    <td width="15" style="background-color: none"><center><%= i %></center></td>
                    <% } %>
                </tr>
                <tr>
                    <% for(int i=21; i<37; i++) { %>
                    <td width="15"><center><%= i %></center></td>
                    <% } %>
                </tr>
            </table>-->
        </div>
                <br/>
        <div>
            <h2>Propositions: </h2>
            <table border="1">
                <tr>
                    <th>Numero</th>
                    <th>Etat dent</th>
                    <th>Cout traitement</th>
                    <th>Cout remplacement</th>
                    <th>Cout nettoyage</th>
                    <th>Total</th>
                </tr>
                
                <% for(V_Dentition den: dentitions) { %>
                    
                    <tr>
                        <td><center><%= den.getIdDent() %></center></td>
                        <td>
                            <center>
                                <%= den.getIdEtat() %> 
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if(den.getTraitement()!=0) { %> <%= den.getTraitement() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if(den.getRemplacement()!=0) { %> <%= den.getRemplacement() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if(den.getNettoyage()!=0) { %> <%= den.getNettoyage() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <%= den.getTotal() %>
                            </center>
                        </td>
                    </tr>
                <% } %>
                
                <input type="hidden" name="choixDents" id="choixDents" value="">
                
            </table>
                <p><strong>Total: </strong><%= prixTotal %></p>
                <p><strong>Reste: </strong><%= reste %></p>
                <br/>
                
                
                <form action="TraitementServlet">
                    <input type="text" name="idPersonne" value="<%= idPersonne %>" hidden>
                    <input type="text" name="argent" value="<%= argent %>" hidden>
                    <input type="text" name="option" value="<%= option %>" hidden>
                    <button type="submit">Valider</button>
                </form>
                
<!--            <form action="ManambotraServlet">
            <input type="hidden" name="idPersonne" value="<%= idPersonne %>">
            <h2>Choisir: </h2>
            <table border="1">
                <tr>
                    <th>Numero</th>
                    <th>Cout traitement</th>
                    <th>Cout remplacement</th>
                    <th>Cout nettoyage</th>
                    <th>Total</th>
                </tr>
                
                <% for(V_Dentition den: dentitionsChoix) { %>
                    
                    <tr>
                        <td><center><%= den.getIdDent() %></center></td>
                        <td>
                            <center>
                                <% if (den.getTraitement() <= argent && den.getIdEtat() != 0) { %>
                                    <label>
                                        <input type="radio" onclick="calculerSomme(this)" name="<%= den.getIdDent() %>" value="<%= den.getTraitement() %>"> <%= den.getTraitement() %>
                                    </label>
                                <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if (den.getRemplacement() <= argent) { %>
                                    <label>
                                        <input type="radio" onclick="calculerSomme(this)" name="<%= den.getIdDent() %>" value="<%= den.getRemplacement() %>"> <%= den.getRemplacement() %>
                                    </label>
                                <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <label>
                                    <input type="radio" onclick="calculerSomme(this)" name="<%= den.getIdDent() %>" value="0" checked> <%= den.getNettoyage() %>
                                </label>
                            </center>
                        </td>
                        <td>
                            <center>
                                <label>
                                    <input type="radio" onclick="calculerSomme(this)" name="<%= den.getIdDent() %>" value="0" checked> <%= den.getTotal() %>
                                </label>
                            </center>
                        </td>
                        <td>
                            <center>
                                <label>
                                    <input type="radio" onclick="calculerSomme(this)" name="<%= den.getIdDent() %>" value="0" checked> Aucun
                                </label>
                            </center>
                        </td>
                    </tr>
                <% } %>
                
                <input type="hidden" name="choixDents" id="choixDents" value="">
                
            </table>
                <p>
                    <button type="submit" onclick="obtenirIdsDentsCoches()" >Valider</button>
                </p>
            </form>
            <p id="resultatSomme"></p>    -->
            
            <script>
                function calculerSomme(clickedRadio) {
                    // Récupérer tous les boutons radio cochés
                    const radios = document.querySelectorAll('input[type="radio"]:checked');

                    // Initialiser la somme
                    let somme = 0;
                    var argent = <%= argent %>;

                    // Ajouter la valeur de chaque bouton radio à la somme
                    radios.forEach(radio => {
                        somme += parseFloat(radio.value);
                    });

                   
                    // Afficher la somme
                    if (somme > argent) {
                        // Annuler la sélection de la dernière option cochée
                        clickedRadio.checked = false;
                    } else {
                        // Afficher la somme
                        document.getElementById('resultatSomme').textContent = "Somme : " + somme;
                    }
                    
                }
                
                function obtenirIdsDentsCoches() {
                    var radiosCoches = document.querySelectorAll('input[type="radio"]:checked');
                    var idsDents = "";

                    radiosCoches.forEach(function(radio) {
                        if (radio.value !== "0") {
                            // Obtenez l'attribut name de la radio
                            var idDent = radio.getAttribute('name');

                            // Ajoutez l'idDent à la chaîne
                            idsDents += idDent + ",";
                        }
                    });

                    // Supprimez la virgule finale si elle existe
                    idsDents = idsDents.replace(/,$/, '');

                    // Mettez à jour la valeur de l'input caché
                    document.getElementById('choixDents').value = idsDents;
                }
            </script>
        </div>
        
        
    </body>
</html>
