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
    private Connection connection = null;
    private String url;
    protected String user;
    protected String password;
    
    public void setConnection() {               
        try {           
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso! \n");
         } catch (SQLException ex) {
            System.out.println("Erro ao acessar o banco: " + ex.getMessage());
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
    
    public void setURL(String url) {
        this.url = url;
    }
    
    public Connection getConnection() {
        return connection;
    }
}

