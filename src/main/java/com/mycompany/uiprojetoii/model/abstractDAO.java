package com.mycompany.uiprojetoii.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Brenda
 */
public abstract class abstractDAO {   
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

    public abstract ResultSet getTextFromDB(int id);
    
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

