package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenda
 */
public class localConnectionDAO extends abstractDAO {
    
    public localConnectionDAO() { 
    }
    
    public static void setUrl() {
        setURL("jdbc:mariadb://localhost:3307/poo");
    }
    
    public static void setUsuario(String user) {
        setUser(user);
    }
    
    public static void setSenha(String password) {
        setPassword(password);
    }
    
    @Override
    public ResultSet getTextFromDB(int id){
        ResultSet res = null;
        try {
            res = getConnection().createStatement().executeQuery(""
                    + "SELECT text FROM textos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        } catch (SQLException ex) {
            Logger.getLogger(localConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }   
}