package com.mycompany.uiprojetoii.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class to conect with a DB
 * @author Brenda
 */
public abstract class DAO {  
    /**
     * private atribute
     */
    private static Connection connection = null;
    /**
     * private atribute
     */
    private static String url;
    /**
     * protected atributes
     */
    protected static String user;
    /**
     * protected atributes
     */
    protected static String password;
   
    /**
     * Sets the connection with the DB
     */
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

    /**
    * Execute a query 
    * @param query string with the query to be executed
    * @return ResultSet with the results
    */
    public ResultSet getFromDB(String query) {
        ResultSet res = null;
        try {
            res = getConnection().createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
   
    /**
    * Abstract method to be overrided
    * @param id integer with the group id 
    * @return ResultSet with the results
    */
    public abstract ResultSet getTextFromDB(int id);
   
    /**
    * Closes the connection with the DB
    */
    public static void endConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao finalizar conexão com o banco: " + ex.getMessage());
        }
    }
   
    /**
     * Sets the DB url.
     * @param u string with the url
     */
    public static void setURL(String u) {
        url = u;
    }
   
    /**
     * Sets the user.
     * @param u string with the user
     */
    public static void setUser(String u) {
        user = u;
    }
   
    /**
     * Sets the password.
     * @param p string with the password
     */
    public static void setPassword(String p) {
        password = p;
    }
   
    /**
     * Gets the connection.
     * @return connection 
     */
    public static Connection getConnection() {
        return connection;
    }
}