
package model;

import database.Connex;
import generalise.Column;
import generalise.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Table(name="dentition")
public class Dentition {
    
    @Column(name="id_dentition", autoIncrement=true, id = true)
    int idDentition;
    
    @Column(name="id_personne")
    int idPersonne;
    
    @Column(name="id_dent")
    int idDent;
    
    @Column(name="etat")
    int etat;
    
    
    
    public static String updateDentitionReparation(int idPersonne, int idDent) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        String query = "UPDATE dentition set etat=10 where id_personne=? and id_dent=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPersonne);
            preparedStatement.setInt(2, idDent);

            preparedStatement.executeUpdate();
            connection.close();
            
            return preparedStatement.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        connection.close();
        return null;
    }
    
    public static String updateDentition(int idPersonne, int idDent, int idEtat) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        String query = "UPDATE dentition set etat=? where id_personne=? and id_dent=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idEtat);
            preparedStatement.setInt(2, idPersonne);
            preparedStatement.setInt(3, idDent);

            preparedStatement.executeUpdate();
            connection.close();
            
            return preparedStatement.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        connection.close();
        return null;
    }
    
    public static String updateDentition(int idPersonne ,int idDent1, int idDent2, int etat) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        String query = "UPDATE dentition set etat=? where id_personne=? and ?<=id_dent and id_dent<=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, etat);
            preparedStatement.setInt(2, idPersonne);
            preparedStatement.setInt(3, idDent1);
            preparedStatement.setInt(4, idDent2);

            preparedStatement.executeUpdate();
            connection.close();
            
            return preparedStatement.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        connection.close();
        return null;
    }
    
    
    
    

    public Dentition(int idPersonne, int idDent, int etat) {
        this.idPersonne = idPersonne;
        this.idDent = idDent;
        this.etat = etat;
    }

    
    public Dentition() {
    }

    public int getIdDentition() {
        return idDentition;
    }

    public void setIdDentition(int idDentition) {
        this.idDentition = idDentition;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdDent() {
        return idDent;
    }

    public void setIdDent(int idDent) {
        this.idDent = idDent;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
}
