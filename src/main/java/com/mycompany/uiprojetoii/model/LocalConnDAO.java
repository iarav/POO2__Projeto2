package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;

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
}