package uiprojetoii.model;

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
        setURL("jdbc:mariadb://localhost:3307/poo");
        user = "root";
        password = "";
        setConnection();
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