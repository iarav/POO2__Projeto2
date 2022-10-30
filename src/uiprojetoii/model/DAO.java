package uiprojetoii.model;

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
    protected Connection connection = null;
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
    
    public void setURL(String url) {
        this.url = url;
    }
    
    public Connection getConnection() {
        return connection;
    }
}