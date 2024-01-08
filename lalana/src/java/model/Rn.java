
package model;

import database.Connex;
import generalise.Column;
import generalise.CrudOperation;
import generalise.Table;
import java.sql.Connection;
import java.sql.SQLException;

@Table(name="rn")
public class Rn {
    
    @Column(name="rn", id=true)
    String rn;
    
    @Column(name="designation")
    String designation;
    
    @Column(name="nb_pk")
    int nbPk;
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = Connex.getConnection();
        CrudOperation crud = new CrudOperation(connection);
        
        crud.selectAll(Rn.class);
        
        connection.close();
    }

    public Rn(String rn, int nbPk) {
        this.rn = rn;
        this.nbPk = nbPk;
    }
    
    

    public Rn() {
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbPk() {
        return nbPk;
    }

    public void setNbPk(int nbPk) {
        this.nbPk = nbPk;
    }
    
    
}
