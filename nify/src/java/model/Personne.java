
package model;

import database.Connex;
import generalise.Column;
import generalise.CrudOperation;
import generalise.Table;
import java.sql.Connection;
import java.sql.SQLException;


@Table(name = "personne")
public class Personne {
    
    @Column(name="id_personne", autoIncrement = true, id = true)
    int idPersonne;
    
    @Column(name="nom")
    String nom;
    
    @Column(name="prenom")
    String prenom;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = Connex.getConnection();
        CrudOperation crud = new CrudOperation(connection);
        
        Personne personne = new Personne("Arimalala", "Anthony");
        String id = crud.saveReturn(personne);
        System.out.println(id);
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    

    public Personne() {
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
