package com.mycompany.uiprojetoii.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Brenda
 */
public abstract class DAO {   
    private static Connection connection = null;
    private static String url;
    protected static String user;
    protected static String password;
    
    public static void setConnection() {               
        if(connection==null){
            try {           
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida com sucesso! \n");
             } catch (SQLException ex) {
                System.out.println("Erro ao acessar o banco: " + ex.getMessage());
            }
        }
    }

    public ResultSet getTextFromDB(String query) {
        ResultSet res = null;
        try {
            res = getConnection().createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void endConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao finalizar conexão com o banco: " + ex.getMessage());
        }
    }
    
    public static void setURL(String u) {
        url = u;
    }
    
    public static void setUser(String u) {
        user = u;
    }
    
    public static void setPassword(String p) {
        password = p;
    }
    
    public Connection getConnection() {
        return connection;
    }
}