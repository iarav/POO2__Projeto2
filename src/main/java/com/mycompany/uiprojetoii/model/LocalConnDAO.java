package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to connect with the local DB
 * @author Brenda
 */
public class LocalConnDAO extends DAO {
   
    /**
    * Default constructor of LocalConnDAO.
    * @param user the user to autenticate
    * @param password the password to autenticate
    */
    public LocalConnDAO(String user, String password) {
        setURL("jdbc:mariadb://localhost:3307/poo");
        setUser(user);
        setPassword(password);
        setConnection();
    }
   
    /**
    * Gets the texts from the local DB
    * @param id the group id
    * @return ResultSet with the lines that corresponds to the group id
    */
    @Override
    public ResultSet getTextFromDB(int id) {
        ResultSet res = getFromDB(""
                    + "SELECT * FROM textos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        return res;
    }
    
    /**
    * Concat all the lines of the text
    * @param id the group id
    * @return String with the complete text
    */
    public String retrieveData(int id){
        
        ResultSet res = getTextFromDB(id);
        
        String text = "";
        
        try {
            while(res.next())
                text += res.getString("text") + "\n";
           
        } catch (SQLException ex) {
            Logger.getLogger(LocalConnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text;
    }
}