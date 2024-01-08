
package model;

import database.Connex;
import generalise.Column;
import generalise.CrudOperation;
import generalise.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Table(name="pk_rn")
public class PkRn {
    
    
    @Column(name="id_pk_rn", autoIncrement = true, id = true)
    int idPkRn;
    
    @Column(name="rn")
    String rn;
    
    @Column(name="pk")
    int pk;
    
    @Column(name="etat")
    int etat = 10;
    
    @Column(name="priorite")
    int priorite;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = Connex.getConnection();
        CrudOperation crud = new CrudOperation(connection);
        
        crud.selectAll(PkRn.class);
        
        connection.close();
    }
    
    public static String updateDentitionReparation(String rn, int pk) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        String query = "UPDATE pk_rn set etat=10 where rn=? and pk=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, rn);
            preparedStatement.setInt(2, pk);

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
    

    public PkRn(String rn, int pk, int priorite) {
        this.rn = rn;
        this.pk = pk;
        this.priorite = priorite;
    }
    
    

    public PkRn() {
    }

    public int getIdPkRn() {
        return idPkRn;
    }

    public void setIdPkRn(int idPkRn) {
        this.idPkRn = idPkRn;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }
    
    
    
}
