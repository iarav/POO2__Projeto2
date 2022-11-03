package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenda
 */
public class LocalConnDAO extends DAO {
   
    public LocalConnDAO(String user, String password) {
        setURL("jdbc:mariadb://localhost:3307/poo");
        setUser(user);
        setPassword(password);
        setConnection();
    }
   
    @Override
    public ResultSet getTextFromDB(int id) {
        ResultSet res = getFromDB(""
                    + "SELECT * FROM textos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        return res;
    }
    
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