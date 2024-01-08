/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalise;

import database.Connex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        Connection connection = Connex.getConnection();
        CrudOperation crud = new CrudOperation(connection);
        
        PersonneTest personne = new PersonneTest("Johary", Date.valueOf("2023-10-14"));
//        crud.save(personne);
//        crud.delete(Personne.class, 7);
        
//        personne.setNom("Ton");
//        crud.update(personne, 2);
        List<PersonneTest> personnes = crud.selectAll(PersonneTest.class);
        System.out.println(personnes.size());
        
        PersonneTest pe = crud.selectById(PersonneTest.class, 3);
        System.out.println(pe.toString());
        
        
    }
}
